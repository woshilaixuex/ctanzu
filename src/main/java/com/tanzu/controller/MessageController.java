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
    @PostMapping("/add")
    public ResponseEntity<ResResult> addMessage(@RequestBody Message message){
        String newMessage = messageService.addMessage(message);
        return ResponseEntity.ok().body(new ResResult(200,"通过",newMessage));
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResResult> getById(@PathVariable Integer id){
        List<String> messages = messageService.getById(id);
        return ResponseEntity.ok().body(new ResResult(200,"通过",messages));
    }
    @GetMapping("/getByCourseId/{courseId}")
    public ResponseEntity<ResResult> getByCourseId(@PathVariable Integer courseId){
        List<String> messages = messageService.getByCourseId(courseId);
        return ResponseEntity.ok().body(new ResResult(200,"通过",messages));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResResult> deleteById(@PathVariable Integer id){
        messageService.deleteById(id);
        return ResponseEntity.ok().body(new ResResult(200,"通过","succed"));
    }

}