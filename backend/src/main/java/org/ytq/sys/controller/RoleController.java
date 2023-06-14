package org.ytq.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.ytq.sys.entity.Role;
import org.ytq.sys.entity.User;
import org.ytq.sys.service.IRoleService;
import org.ytq.sys.service.IUserService;
import org.ytq.vo.Encapulation;

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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;


    @GetMapping("/list")
    public Encapulation<Map<String, Object>> getRoleList(@RequestParam(value = "roleName", required = false) String roleName,
                                                         @RequestParam(value = "pageNo") Long pageNo,
                                                         @RequestParam(value = "pageSize") Long pageSize){
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(roleName), Role::getRoleName, roleName);
        Page<Role> pages = new Page<>(pageNo, pageSize);
        roleService.page(pages, wrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("total", pages.getTotal());
        data.put("rows", pages.getRecords());
        return Encapulation.success(data);
    }

    @PostMapping
    public Encapulation<?> addRole(@RequestBody Role role){
        roleService.addRole(role);
        return Encapulation.success("新增角色成功");
    }

    @PutMapping
    public Encapulation<?> updateRole(@RequestBody Role role){
        roleService.updateById(role);
        return Encapulation.success("修改角色成功");
    }

    @GetMapping("/{id}")
    public Encapulation<Role> getRoleById(@PathVariable("id") Integer id){
        Role role = roleService.getRoleById(id);
        return Encapulation.success(role);
    }

    @DeleteMapping("/{id}")
    public Encapulation<Role> deleteRoleById(@PathVariable("id") Integer id){
        roleService.removeById(id);
        return Encapulation.success("删除角色成功");
    }

}
