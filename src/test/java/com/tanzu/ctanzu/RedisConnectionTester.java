package com.tanzu.ctanzu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisConnectionTester {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Test
    public void testRedisConnection() {
        try {
            RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
            connection.close();
            System.out.println("Redis connection test successful.");
        } catch (Exception e) {
            System.out.println("Redis connection test failed.");
            e.printStackTrace();
        }
    }
}
