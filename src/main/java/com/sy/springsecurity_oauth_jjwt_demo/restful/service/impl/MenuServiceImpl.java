package com.sy.springsecurity_oauth_jjwt_demo.restful.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.Menu;
import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.MenuRole;
import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.bo.MenuRolesBO;
import com.sy.springsecurity_oauth_jjwt_demo.restful.mapper.MenuMapper;
import com.sy.springsecurity_oauth_jjwt_demo.restful.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 孙宇
 * @since 2021-10-04
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuRolesBO> getMenuRolesList() {
        List<MenuRolesBO> menuRolesBOList = menuMapper.getMenuRolesList();
        return null;
    }
}
