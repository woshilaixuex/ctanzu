package com.tanzu.aop;

import com.tanzu.config.AuthenticatedUserContainer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//@Component
//@Aspect
public class TokenProxy {
    @Pointcut("execution (* com.tanzu.controller.CourseController.*(..))")
    public void tokenVerification() {

    }
    @Before("tokenVerification()")
    public void beforeAdvice(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("Token");
        String username = AuthenticatedUserContainer.getAuthenticatedUser(token);
    }
}
