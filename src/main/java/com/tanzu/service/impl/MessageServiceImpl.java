package com.tanzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tanzu.domain.Message;
import com.tanzu.mapper.MessageMapper;
import com.tanzu.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<Message> findAllMessage() {
        List<Message> messageList = messageMapper.selectAllMessage();
        return messageList;
    }

    @Override
    public String addMessage(Message message) {
        message.setTime(LocalDateTime.now());
        messageMapper.insertMessage(message);
        return null;
    }

    @Override
    public List<String> getById(Integer id) {
        LambdaQueryWrapper<Message> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Message::getId,id);
        if (wrapper == null) {
            // 异常处理
        }
        List<String> stringList = messageMapper.selectById(id);

        return stringList;
    }

    @Override
    public List<String> getByCourseId(Integer courseId) {
        LambdaQueryWrapper<Message> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Message::getCourseId,courseId);
        if (wrapper == null) {
            // 异常处理
        }
        List<String> stringList = messageMapper.selectByCourseId(courseId);
        return stringList;
    }

    @Override
    public void deleteById(Integer id) {
        LambdaQueryWrapper<Message> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Message::getId,id);
        if (wrapper == null) {
            // 异常处理
        }
        messageMapper.deleteById(id);
    }
}
