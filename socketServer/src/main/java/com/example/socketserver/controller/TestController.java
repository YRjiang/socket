package com.example.socketserver.controller;

import com.example.socketserver.componet.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private WebSocketServer webSocketServer;

    /**
     * 给指定用户推送消息
     * @param userName 用户名
     * @param message 消息
     * @throws IOException
     */
    @RequestMapping(value = "/appointSend", method = RequestMethod.GET)
    public void testSocket1(@RequestParam String userName, @RequestParam String message){
        webSocketServer.AppointSending("zhonggao", "message");
    }


    /**
     * 给所有用户推送消息
     * @param message 消息
     * @throws IOException
     */
    @RequestMapping(value = "/sendAll", method = RequestMethod.GET)
    public void pushAllSocket(@RequestParam String message){
        try {
            webSocketServer.GroupSending(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
