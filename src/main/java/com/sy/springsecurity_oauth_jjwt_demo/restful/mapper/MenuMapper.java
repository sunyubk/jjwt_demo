package com.sy.springsecurity_oauth_jjwt_demo.restful.mapper;

import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.bo.MenuRolesBO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 孙宇
 * @since 2021-10-04
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuRolesBO> getMenuRolesList();
}
