package com.tanzu.controller;


import com.tanzu.common.ResResult;
import com.tanzu.domain.Message;
import com.tanzu.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tanzu/message")
public class MessageController {
    @Resource
    private MessageService messageService;
    @GetMapping("/findAll")
    public ResponseEntity<ResResult> findAllMessage(){
        List<Message> messages = messageService.findAllMessage();
        return ResponseEntity.ok().body(new ResResult(200,"通过",messages));
    }
    @PostMapping("/add/{courseId}")
    public ResponseEntity<ResResult> addMessage(@RequestBody Message message,@PathVariable Long courseId){
        System.out.println(message);
        message.setCourseId(courseId);
        Message newMessage = messageService.addMessage(message);
        return ResponseEntity.ok().body(new ResResult(200,"通过",newMessage));
    }
    @GetMapping("/{courseId}")
    public ResponseEntity<ResResult> getByCourseId(@PathVariable Long courseId){
        List<Message> messages = messageService.getByCourseId(courseId);
        return ResponseEntity.ok().body(new ResResult(200,"通过",messages));
    }



}