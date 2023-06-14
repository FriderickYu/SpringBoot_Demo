package org.ytq;

import org.ytq.sys.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.ytq.sys.mapper.*;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class BackendApplicationTests {

    @Resource
    private UserMapper userMapper;
    // 测试, 查询user表内所有记录
    @Test
    void selectAllFromUserTest() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
