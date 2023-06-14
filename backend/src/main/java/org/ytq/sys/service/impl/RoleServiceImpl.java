package org.ytq.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.ytq.sys.entity.Role;
import org.ytq.sys.entity.RoleMenu;
import org.ytq.sys.mapper.RoleMapper;
import org.ytq.sys.mapper.RoleMenuMapper;
import org.ytq.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yutianqi
 * @since 2023-06-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Override
    public void addRole(Role role) {
        // 写入角色表
        this.baseMapper.insert(role);
        // 写入角色与菜单权限的对照表
        if(null != role.getMenuIdList()){
            for(Integer menuId : role.getMenuIdList()){
                roleMenuMapper.insert(new RoleMenu(null, role.getRoleId(), menuId));
            }
        }

    }

    @Override
    public Role getRoleById(Integer id) {
        Role role = this.baseMapper.selectById(id);
        List<Integer> menuIdList = roleMenuMapper.getMenuIdListByRoleId(id);
        role.setMenuIdList((menuIdList));
        return role;
    }
}
