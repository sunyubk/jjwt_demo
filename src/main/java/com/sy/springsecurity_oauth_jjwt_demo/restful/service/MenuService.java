package com.sy.springsecurity_oauth_jjwt_demo.restful.service;

import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.bo.MenuRolesBO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 孙宇
 * @since 2021-10-04
 */
public interface MenuService extends IService<Menu> {

    /**
     * 获取菜单角色集合
     * @return List<MenuRolesBO>
     */
    List<MenuRolesBO> getMenuRolesList();
}
