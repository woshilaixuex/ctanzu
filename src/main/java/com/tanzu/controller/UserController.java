package com.tanzu.controller;

import com.tanzu.common.ResResult;
import com.tanzu.common.RespCode;
import com.tanzu.domain.User;
import com.tanzu.service.UserService;
import com.tanzu.util.JWT;
import com.tanzu.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 登录注册
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JWT jWt;
    @GetMapping("/tanzu/user/vercode")
    public void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        String text = vc.getText();
        HttpSession session = req.getSession();
        session.setAttribute("vercode", text);
        VerifyCode.output(image, resp.getOutputStream());
    }
    @PostMapping("/tanzu/user/register")
    public ResponseEntity<ResResult> register(@RequestBody @Validated User user)
            throws TimeoutException {
        User logeuser = userService.loadUserByUsername(user.getUsername());
        if(logeuser != null) return ResponseEntity.status(RespCode.USER_ALREADY_EXISTS)
                .body(new ResResult(RespCode.USER_ALREADY_EXISTS,"已存在该用户",null));
        return ResponseEntity.ok(new ResResult(200,"通过",null));
    }
    @PostMapping("/tanzu/user/login")
    public ResponseEntity<ResResult> login(HttpServletRequest req, HttpServletResponse resp,@RequestBody User user)
            throws TimeoutException {
        String code =  (String) req.getSession().getAttribute("vercode");
        if(user.getVercode() == null || code == null || !code.equalsIgnoreCase(user.getVercode())) {
            return ResponseEntity.status(410).body(new ResResult(410,"验证码错误",null)); // 这里响应码要改下
        }else{
            User logeuser = userService.loadUserByUsername(user.getUsername());
            if (logeuser == null) return ResponseEntity.status(RespCode.USER_NOT_FOUND)
                    .body(new ResResult(RespCode.USER_NOT_FOUND, "不存在该用户", null));
            String token = jWt.makeToken(user, 60 * 60 * 12);
            return ResponseEntity.ok(new ResResult(200, "通过", token));
        }
    }
}
