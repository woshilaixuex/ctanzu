package com.tanzu.util;


import com.tanzu.domain.User;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;


/**
 * jwt
 */
@Component
@Slf4j
public class JWT {
    private String signature = "admin";
    @Autowired
    private  StringRedisTemplate stringRedisTemplate;
    public static StringRedisTemplate stringRedisTemplateStatic;

    @PostConstruct
    private void initStringRedisTemplate(){
        stringRedisTemplateStatic = this.stringRedisTemplate;
    }
    public String makeToken(User user, long time){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("username", user.getUsername())
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        stringRedisTemplateStatic.opsForValue().set("token",jwtToken);
        return jwtToken;
    }
    public String parseToken(String NewToken){
        String token = NewToken;
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        String username = claims.get("username",String.class);
        if(username.isEmpty()){
            System.out.println("不存在");
            return null;
        }else {
            String storedToken = stringRedisTemplateStatic.opsForValue().get("token");
            if (storedToken != null) {
                if (storedToken.equals(token)) {
                    return username;
                } else {
                    return null;
                }
            } else {
                log.info("未在redis中找到Token");
                return null;
            }
        }
    }
}
