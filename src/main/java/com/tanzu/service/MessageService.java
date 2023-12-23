package com.tanzu.service;


import com.tanzu.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAllMessage();

    String addMessage(Message message);

    List<String> getById(Integer id);

    List<String> getByCourseId(Integer courseId);

    void deleteById(Integer id);
}