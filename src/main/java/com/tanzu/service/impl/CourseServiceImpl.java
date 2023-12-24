package com.tanzu.service.impl;


import com.tanzu.domain.Course;
import com.tanzu.domain.Message;
import com.tanzu.mapper.CourseMapper;
import com.tanzu.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    MessageServiceImpl messageService;
    @Override
    public List<Course> getAllCourse() {
        return courseMapper.selectList(null);
    }
    @Transactional
    @Override
    public Course getCourseById(Long id) {
        Course course = courseMapper.selectById(id);
        course.setMessages(messageService.getByCourseId(id));
        return course;
    }
}
