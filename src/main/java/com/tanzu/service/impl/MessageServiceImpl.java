package com.tanzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tanzu.domain.Message;
import com.tanzu.domain.User;
import com.tanzu.domain.UserInform;
import com.tanzu.mapper.MessUserMapper;
import com.tanzu.mapper.MessageMapper;
import com.tanzu.mapper.UserInformMapper;
import com.tanzu.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;
    @Autowired
    MessUserMapper messUserMapper;
    @Autowired
    private UserInformMapper userInformMapper;

    @Override
    public List<Message> findAllMessage() {
        List<Message> messageList = messageMapper.selectList(null);
        return messageList;
    }
    @Transactional
    @Override
    public Message addMessage(Message message) {
        try {
            message.setTime(LocalDateTime.now());
            messageMapper.insert(message);
            Integer maxId = messageMapper.selectMaxId();
            message.setId(maxId);
            messUserMapper.saveUserMess(message.getUserId(), message.getId());
            String name = userInformMapper.selectUserNameById(message.getUserId());
            message.setUserName(name);
            return message;
        }catch (Exception e){
            log.info(e.getMessage());
            throw e;
        }
    }

    @Transactional
    @Override
    public List<Message> getByCourseId(Long courseId) {
        LambdaQueryWrapper<Message> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Message::getCourseId,courseId);
        if (wrapper == null) {
            // 异常处理
        }
        List<Message> messages = messageMapper.selectByCourseId(courseId);
        return messages;
    }

}
