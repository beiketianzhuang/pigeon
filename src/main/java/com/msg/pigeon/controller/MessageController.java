package com.msg.pigeon.controller;

import com.msg.pigeon.model.req.MessageReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MessageController {

    @PostMapping("/msg/producer")
    public void sendMsg(@RequestBody @Valid MessageReq messageReq) {

    }

}
