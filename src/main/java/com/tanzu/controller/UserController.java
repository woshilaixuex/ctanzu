package com.tanzu.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.tanzu.common.ResResult;
import com.tanzu.domain.User;
import com.tanzu.util.VerifyCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class UserController {
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
    public ResponseEntity<ResResult> register(@RequestBody User user) {
        return ResponseEntity.ok(new ResResult(200,"通过",null));
    }
}
