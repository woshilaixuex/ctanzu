package com.tanzu.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class JWT {
//    private String signature = "admin";
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    public String makeToken(User user, long time){
//        JwtBuilder jwtBuilder = Jwts.builder();
//        String jwtToken = jwtBuilder
//                .setHeaderParam("typ", "JWT")
//                .setHeaderParam("alg", "HS256")
//                .claim("num", user.getNum())
//                .setSubject("admin-test")
//                .setExpiration(new Date(System.currentTimeMillis() + time))
//                .setId(UUID.randomUUID().toString())
//                .signWith(SignatureAlgorithm.HS256, signature)
//                .compact();
//        return jwtToken;
//    }
//    public String parseToken(String NewToken){
//        String token = NewToken;
//        JwtParser jwtParser = Jwts.parser();
//        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
//        Claims claims = claimsJws.getBody();
//        String num = claims.get("num",String.class);
//        String storedToken = stringRedisTemplate.opsForValue().get(num);
//        if(storedToken != null) {
//            if (storedToken.equals(token)) {
//                return num;
//            } else {
//                return null;
//            }
//        }else{
//            log.info("未在redis中找到Token");
//            return null;
//        }
//    }
}
