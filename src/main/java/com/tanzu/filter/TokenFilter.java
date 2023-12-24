package com.tanzu.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanzu.common.ResResult;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 验证码过滤器
 */
@Component
@Slf4j
public class TokenFilter implements Filter{

//    @Autowired
    private final ObjectMapper objectMapper;

    public TokenFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void init(FilterConfig filterConfig){
        log.info("过滤器创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();
        if(path.startsWith("/tanzu/user/")){
            filterChain.doFilter(request, servletResponse);
            return;
        }
        try {
            String token = request.getHeader("Token");
            if(token.isEmpty()){
                ResResult resResult = new ResResult(411, "Token is null ", null);
                sendErrorResponse(response, resResult);
                return;
            }
            filterChain.doFilter(request, servletResponse);
        }catch (Exception e){
            ResResult resResult = new ResResult(411, "Token is null ", null);
            sendErrorResponse(response, resResult);
            return;
        }
    }

    @Override
    public void destroy() {
        // 过滤器销毁操作
    }
    private void sendErrorResponse(HttpServletResponse response, ResResult resResult) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(resResult.getCode());
        response.getWriter().write(objectMapper.writeValueAsString(resResult));
    }
}
