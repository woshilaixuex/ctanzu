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
//        User user = new User();
//        user.setUsername("adad");
//        String token = jwt.makeToken(user,60*60*60);
//        System.out.println(token);
        String a = jwt.parseToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImdvYm95Iiwic3ViIjoiYWRtaW4tdGVzdCIsImV4cCI6MTcwMzM2MzQ5OCwianRpIjoiNzc3ODIxYTQtNGQwOS00YjM4LWJmZDQtOWJmMzdkNTc0MjBkIn0.c_72QCCJxxa6ODHiQxeNn6cMjTtoT_G4GExqV3x9q6U");
        System.out.println(a);
    }

}
