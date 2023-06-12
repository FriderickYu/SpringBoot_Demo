package org.ytq.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.ytq.sys.entity.User;
import org.ytq.sys.service.IUserService;
import org.ytq.vo.*;

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

}
