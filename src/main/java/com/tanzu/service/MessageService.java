package com.tanzu.service;


import com.tanzu.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAllMessage();

    Message addMessage(Message message);

    List<Message> getByCourseId(Long courseId);


}