package org.ytq;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.ytq.sys.entity.User;
import org.ytq.utils.JwtUtil;

@SpringBootTest
public class JwtUtilTest {
    @Autowired
    private JwtUtil jwtUtil;
    @Test
    public void testCreateJwt(){
        User user = new User();
        user.setUsername("zhugeliang");
        user.setPhone("13933333333");
        String token = jwtUtil.createToken(user);
        System.out.println(token);
    }
    @Test
    public void testParseJwt(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyMWUzMGZiOC1mYzYzLTQ5MjUtOWU0YS03M2JmOGMxM2NiZjMiLCJzdWIiOiJ7XCJwaG9uZVwiOlwiMTM5MzMzMzMzMzNcIixcInVzZXJuYW1lXCI6XCJ6aHVnZWxpYW5nXCJ9IiwiaXNzIjoic3lzdGVtIiwiaWF0IjoxNjg2NzA4Mjc5LCJleHAiOjE2ODY3MTAwNzl9.pXC0LhJLFzqD5Qaz0oL3_wdFqCUZ9taouyqcCzV5v8U";
        User user= jwtUtil.parseToken(token, User.class);
        System.out.println(user);
    }
}
