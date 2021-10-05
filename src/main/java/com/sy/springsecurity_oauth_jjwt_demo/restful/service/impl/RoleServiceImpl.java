package com.sy.springsecurity_oauth_jjwt_demo.restful.service.impl;

import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.Role;
import com.sy.springsecurity_oauth_jjwt_demo.restful.mapper.RoleMapper;
import com.sy.springsecurity_oauth_jjwt_demo.restful.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 孙宇
 * @since 2021-10-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
