package com.tanzu.service.impl;


import com.tanzu.domain.Course;
import com.tanzu.mapper.CourseMapper;
import com.tanzu.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> getAllCourse() {
        return null;
    }
}
