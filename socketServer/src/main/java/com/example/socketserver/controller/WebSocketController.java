package com.example.socketserver.controller;

import com.example.socketserver.componet.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/webSocketController")
public class WebSocketController {

    @Autowired
    private WebSocketServer webSocketServer;

    @Autowired
    private PushZhongGaoJob pushZhongGaoJob;

    /**
     * 给指定用户推送消息
     * @param userName 用户名
     * @param message 消息
     * @throws IOException
     */
    @RequestMapping(value = "/sendAppoint", method = RequestMethod.GET)
    public void putAppointSocket(@RequestParam String userName, @RequestParam String message){
        webSocketServer.AppointSending(userName, message);
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

    @GetMapping("/job")
    public void job() {
        pushZhongGaoJob.aiWarnRecordTest();
    }

}
