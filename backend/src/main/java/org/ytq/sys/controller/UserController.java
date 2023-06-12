package org.ytq.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.ytq.sys.entity.User;
import org.ytq.sys.service.IUserService;
import org.ytq.vo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yutianqi
 * @since 2023-06-07
 */

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/all")
    public Encapulation<List<User>>getAllUser(){
        List<User> list = userService.list();
        return Encapulation.success(list, "查询成功");
    }

    // 登录接口
    @PostMapping("/login")
    public Encapulation<Map<String, Object>> login(@RequestBody User user){
        Map<String, Object> data = userService.login(user);
        if(data != null){
            return Encapulation.success(data);
        }
        return Encapulation.fail(20002, "用户名或密码错误");
    }

    @GetMapping("/info")
    public Encapulation<Map<String, Object>> getUserInfo(@RequestParam("token") String token){
        // 根据token获取用户信息
        Map<String, Object> data = userService.getUserInfo(token);
        if(data != null){
            return Encapulation.success(data);
        }
        return Encapulation.fail(20003, "登录信息无效，请重新登录");
    }

    @PostMapping("/logout")
    public Encapulation<?> logout(@RequestHeader("X-Token") String token){
        userService.logout(token);
        return Encapulation.success();
    }

    @GetMapping("/list")
    public Encapulation<Map<String, Object>> getUserList(@RequestParam(value = "username", required = false) String username,
                                                     @RequestParam(value = "phone", required = false) String phone,
                                                     @RequestParam(value = "pageNo") Long pageNo,
                                                     @RequestParam(value = "pageSize") Long pageSize){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(username), User::getUsername, username);
        wrapper.eq(StringUtils.hasLength(phone), User::getPhone, phone);
        Page<User> pages = new Page<>(pageNo, pageSize);
        userService.page(pages, wrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("total", pages.getTotal());
        data.put("rows", pages.getRecords());
        return Encapulation.success(data);
    }

    @PostMapping
    public Encapulation<?> addUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return Encapulation.success("新增用户成功");
    }

    @PutMapping
    public Encapulation<?> updateUser(@RequestBody User user){
        user.setPassword(null);
        userService.updateById(user);
        return Encapulation.success("修改用户成功");
    }

    @GetMapping("/{id}")
    public Encapulation<User> getUserById(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        return Encapulation.success(user);
    }

    @DeleteMapping("/{id}")
    public Encapulation<User> deleteUserById(@PathVariable("id") Integer id){
        userService.removeById(id);
        return Encapulation.success("删除用户成功");
    }

}
