package com.tanzu.controller;

import com.tanzu.config.AuthenticatedUserContainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CourseController {
    @GetMapping()
    public void getAllCourse(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String username = AuthenticatedUserContainer.getAuthenticatedUser(token);
    }
}
