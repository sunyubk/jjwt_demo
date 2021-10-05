package com.sy.springsecurity_oauth_jjwt_demo;

import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.bo.MenuRolesBO;
import com.sy.springsecurity_oauth_jjwt_demo.restful.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @ClassName ApiTest
 * @Description TODO
 * @Author sy
 * @Date 2021/10/4 18:39
 * @Version 1.0
 **/
@SpringBootTest
public class ApiTest {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void getMenuTest() {
        List<MenuRolesBO> menuRolesBOList = menuMapper.getMenuRolesList();
        System.out.println(menuRolesBOList);
    }

}
