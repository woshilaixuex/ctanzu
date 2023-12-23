package com.tanzu.controller;


import com.tanzu.domain.Message;
import com.tanzu.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tanzu/message")
public class MessageController {
    @Resource
    private MessageService messageService;
    @GetMapping("/findAll")
    public List<Message> findAllMessage(){
        return messageService.findAllMessage();
    }
    @PostMapping("/add")
    public String addMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }
    @GetMapping("/getById/{id}")
    public List<String> getById(@PathVariable Integer id){
        return messageService.getById(id);
    }
    @GetMapping("/getByCourseId/{courseId}")
    public List<String> getByCourseId(@PathVariable Integer courseId){
        return messageService.getByCourseId(courseId);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        messageService.deleteById(id);
    }

}