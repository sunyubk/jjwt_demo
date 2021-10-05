package com.sy.springsecurity_oauth_jjwt_demo.restful.beans.bo;

import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.Menu;
import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @ClassName MenuRoleBO
 * @Description TODO
 * @Author sy
 * @Date 2021/10/4 18:23
 * @Version 1.0
 **/
@EqualsAndHashCode(callSuper = false)
@Data
public class MenuRolesBO extends Menu {
    List<Role> roleList;
}
