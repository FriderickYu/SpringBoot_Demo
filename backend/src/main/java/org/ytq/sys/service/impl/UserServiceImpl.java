package org.ytq.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.ytq.sys.entity.User;
import org.ytq.sys.mapper.UserMapper;
import org.ytq.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yutianqi
 * @since 2023-06-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private RedisTemplate redisTemplate;
    // 用户登录具体的逻辑
    @Override
    public Map<String, Object> login(User user) {

        // 根据用户名和密码查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        wrapper.eq(User::getPassword, user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);
        // 如果结果是对的, 则生成token, 并将token存入redis
        if(loginUser != null){
            // UUID
            String key = "user:" + UUID.randomUUID();
            // 存入redis
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key, loginUser, 30, TimeUnit.MINUTES);
            // 返回数据

            Map<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        // 根据token获取用户信息, redis
        Object object = redisTemplate.opsForValue().get(token);
        if(object != null){
            User loginUser = JSON.parseObject(JSON.toJSONString(object), User.class);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", loginUser.getUsername());
            hashMap.put("avatar", loginUser.getAvatar());
            // 角色
            List<String> roleList = this.baseMapper.getRoleNameByUserId(loginUser.getId());
            hashMap.put("roles", roleList);
            return hashMap;
        }
        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }
}
