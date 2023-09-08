package com.example.socketclient.controller;

import com.example.socketclient.service.impl.ScoketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/indexWebsocket")
public class IndexController {

    @Autowired
    private ScoketClient webScoketClient;

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam(value = "message") String message){
        webScoketClient.groupSending(message);
        return message;
    }

}
