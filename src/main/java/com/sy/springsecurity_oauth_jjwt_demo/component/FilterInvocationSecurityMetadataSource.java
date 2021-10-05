package com.sy.springsecurity_oauth_jjwt_demo.component;

import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.Menu;
import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.Role;
import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.bo.MenuRolesBO;
import com.sy.springsecurity_oauth_jjwt_demo.restful.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName FilterInvocationSecurityMetadataSource
 * @Description TODO 该类的主要功能就是通过当前的请求地址，获取该地址需要的用户角色
 * @Author sy
 * @Date 2021/10/4 17:56
 * @Version 1.0
 **/
@Component
public class FilterInvocationSecurityMetadataSource implements org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        if ("/login".equals(requestUrl)) {
            return null;
        }
        //获取所有菜单及可以访问的角色
        List<MenuRolesBO> allMenu = menuService.getMenuRolesList();
        for (MenuRolesBO menuRolesBO : allMenu) {
            //请求地址与 allMenu 对象中的菜单比较
            if (antPathMatcher.match(menuRolesBO.getUrl(), requestUrl) && menuRolesBO.getRoleList().size() > 0) {
                //可以访问当前请求的所有角色
                List<Role> roles = menuRolesBO.getRoleList();
                //遍历roles,添加进security的集合中，在UrlAccessDecisionManager中会用到
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getRoleName();
                }
                return SecurityConfig.createList(values);
            }
        }

        //与角色无关，登录了就可以访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
