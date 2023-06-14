package org.ytq.sys.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.ytq.sys.entity.Menu;
import org.ytq.sys.service.IMenuService;
import org.ytq.vo.Encapulation;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yutianqi
 * @since 2023-06-07
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService iMenuService;
    @ApiOperation("查询所有菜单数据")
    @GetMapping
    public Encapulation<List<Menu>> getAllMenu(){
        List<Menu> menuList = iMenuService.getAllMenu();

        return Encapulation.success(menuList);
    }
}
