package com.tanzu.controller;

import com.tanzu.common.ResResult;
import com.tanzu.domain.Course;
import com.tanzu.service.impl.CourseServiceImpl;
import com.tanzu.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/tanzu/course")
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/courses")
    public ResponseEntity<ResResult> getAllCourse(){
        List<Course> courses = courseService.getAllCourse();
        return ResponseEntity.ok(new ResResult(200, "通过", courses));
    }
    @GetMapping("/courses/{id}")
    public ResponseEntity<ResResult> getCourseById(@PathVariable Long id){
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(new ResResult(200, "通过", course));
    }
}
