package com.tanzu.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanzu.common.ResResult;
import com.tanzu.domain.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;


/**
 * 验证码过滤器
 */
@Component
@Slf4j
public class LoginFilter implements Filter {

    @Autowired
    private final ObjectMapper objectMapper;

    public LoginFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();
        if (!path.startsWith("/tanzu/user/register")) {
            filterChain.doFilter(request, servletResponse);
            return;
        }
        if (!request.getMethod().equals("POST")) {
            ResResult resResult = new ResResult(201, "Authentication method not supported: " + request.getMethod(), null);
            sendErrorResponse(response, resResult);
            return;
        }
        String verifyCode = (String) request.getSession().getAttribute("vercode");
        User user = readRequestBody(request, User.class);
        if (verifyCode == null || !verifyCode.equals(user.getVercode())) {
            // 验证码不匹配，返回错误响应
            ResResult resResult = new ResResult(202, "Invalid verification code", null);
            sendErrorResponse(response, resResult);
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 过滤器销毁操作
    }

    private <T> T readRequestBody(HttpServletRequest request, Class<T> valueType) throws IOException {
        String contentType = request.getContentType();
        if (contentType != null && contentType.startsWith(MediaType.APPLICATION_JSON_VALUE)) {
            return objectMapper.readValue(request.getReader(), valueType);
        }
        return null;
    }

    private void sendErrorResponse(HttpServletResponse response, ResResult resResult) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(resResult.getCode());
        response.getWriter().write(objectMapper.writeValueAsString(resResult));
    }
}
