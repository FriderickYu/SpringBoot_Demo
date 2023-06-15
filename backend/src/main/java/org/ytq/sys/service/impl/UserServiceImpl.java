package org.ytq.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.ytq.sys.entity.User;
import org.ytq.sys.entity.UserRole;
import org.ytq.sys.mapper.UserMapper;
import org.ytq.sys.mapper.UserRoleMapper;
import org.ytq.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ytq.utils.JwtUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
    @Resource
    private UserRoleMapper userRoleMapper;
    // 用户登录具体的逻辑
    @Override
    public Map<String, Object> login(User user) {

        // 根据用户名和密码查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User loginUser = this.baseMapper.selectOne(wrapper);
        // 结果不为空，并且密码和传入的密码是匹配的
        // 如果结果是对的, 则生成token, 并将token存入redis
        // 将加密过的密码和实际密码进行比对
        if(loginUser != null && passwordEncoder.matches(user.getPassword(), loginUser.getPassword())){
            // UUID
            // String key = "user:" + UUID.randomUUID();
            // 存入redis
             loginUser.setPassword(null);
            // redisTemplate.opsForValue().set(key, loginUser, 30, TimeUnit.MINUTES);
            // 返回数据

            // 创建jwt
            String token = jwtUtil.createToken(loginUser);

            Map<String, Object> data = new HashMap<>();
            data.put("token", token);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        // 根据token获取用户信息, redis
        // Object object = redisTemplate.opsForValue().get(token);
        User loginUser = null;
        try {
            loginUser = jwtUtil.parseToken(token, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(loginUser != null){
            // User loginUser = JSON.parseObject(JSON.toJSONString(object), User.class);
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
        // redisTemplate.delete(token);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        // 写入用户表
        this.baseMapper.insert(user);
        // 写入用户角色表
        List<Integer> roleIdList = user.getRoleIdList();
        if(roleIdList != null){
            for (Integer roleId : roleIdList) {
                userRoleMapper.insert(new UserRole(null, user.getId(), roleId));
            }
        }
    }

    @Override
    public User getUserById(Integer id) {
        User user = this.baseMapper.selectById(id);

        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getUserId,id);
        List<UserRole> userRoleList = userRoleMapper.selectList(wrapper);

        List<Integer> roleIdList = userRoleList.stream()
                .map(UserRole::getRoleId)
                .collect(Collectors.toList());
        user.setRoleIdList(roleIdList);

        return user;
    }
}
