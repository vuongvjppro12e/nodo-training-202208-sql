package com.example.unit13.controller;

import com.example.unit13.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessagerController {

    @MessageMapping("/message")
    @SendTo("/topic/chat")
    public Message say(Message message){
        System.out.println("From Client: "+message.getContent());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Message("hanoi: "+message.getContent()+"!");
    }
}
