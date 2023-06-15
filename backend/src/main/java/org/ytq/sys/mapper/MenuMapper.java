package org.ytq.sys.mapper;

import org.apache.ibatis.annotations.Param;
import org.ytq.sys.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yutianqi
 * @since 2023-06-07
 */
public interface MenuMapper extends BaseMapper<Menu> {
    public List<Menu> getMenuListByUserId(@Param("userId") Integer userId, @Param("pid") Integer pid);
}
