package com.tanzu.ctanzu;

import com.tanzu.domain.User;
import com.tanzu.util.JWT;
import com.tanzu.util.VerifyCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CtanzuApplicationTests {

    @Test
    void contextLoads() {
        JWT jwt = new JWT();
        User user = new User();
        user.setUsername("adad");
        String token = jwt.makeToken(user,60*60*60);
        System.out.println(token);
        String a = jwt.parseToken(token);
        System.out.println(a);
    }

}
