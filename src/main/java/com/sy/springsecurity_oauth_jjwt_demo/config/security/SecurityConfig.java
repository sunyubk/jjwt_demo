package com.sy.springsecurity_oauth_jjwt_demo.config.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sy.springsecurity_oauth_jjwt_demo.consts.Const;
import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.SysUser;
import com.sy.springsecurity_oauth_jjwt_demo.restful.beans.UserRole;
import com.sy.springsecurity_oauth_jjwt_demo.restful.service.SysUserService;
import com.sy.springsecurity_oauth_jjwt_demo.restful.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author sy
 * @Date 2021/9/7 20:24
 * @Version 1.0
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserRoleService userRoleService;


    /**
     * 密码模式中使用
     * @return authenticationManager
     * @throws Exception exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * 将 PasswordEncoder 交由 spring 管理
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    /**
     * 自定义逻辑
     * @return User
     */
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return username -> {
            //1.根据用户名去数据库查询，如果不存在抛出 UsernameNotFoundException 异常
            LambdaQueryWrapper<SysUser> userQuery = Wrappers.lambdaQuery();
            SysUser sysUser = sysUserService.getOne(userQuery.eq(SysUser::getUsername, username));
            if (!sysUser.getUsername().equals(username)) {
                throw new UsernameNotFoundException("用户名不存在");
            }
            //2.在数据库中查询到用户的相关信息进行整理，例如角色，权限标志，路由等
            //根据用户id查询角色id
            LambdaQueryWrapper<UserRole> userRoleLambdaQueryWrapper = Wrappers.lambdaQuery();
            List<UserRole> userRoleList = userRoleService.list(userRoleLambdaQueryWrapper.eq(UserRole::getUid, sysUser.getId()));

            Set<String> dbAuthsSet = new HashSet<>();
            for (UserRole userRole : userRoleList) {
                dbAuthsSet.add("admin");
                dbAuthsSet.add("user");
                //设置角色，必须 ROLE_ 开头，硬性要求
                dbAuthsSet.add(Const.ROLE+ userRole.getRid());
                // 配合自定义access方法使用
                dbAuthsSet.add("/main.html");
            }


            //3.将权限信息等转换为List，传入 security 的 User。
            List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(dbAuthsSet.toArray(new String[]{}));

            //比较密码（注册时已经加密过），如果匹配成功返回 UserDetails，这里就是在数据库中查询的密码
            //String password = passwordEncoder().encode("1");
            return new User(username,sysUser.getPassword(),authorities);
        };

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ////表单提交
        //http.formLogin()
        //        //自定义用户名参数，必须与form中的name一样
        //        //.usernameParameter("username")
        //        //自定义密码参数，必须与form中的name一样
        //        //.passwordParameter("password")
        //        //自定义登录页面
        //        .loginPage("/showLogin")
        //        //必须和表单提交的接口一样，会去执行自定义登录逻辑
        //        .loginProcessingUrl("/login")
        //        //登录成功后跳转的页面，必须是post请求
        //        .successForwardUrl("/toMain")
        //        //自定义登录成功后的处理器，进行重定。
        //        //.successHandler(new MyAuthenticationSuccessHandler("/main.html"))
        //        //登录失败后跳转的页面，必须是post请求
        //        .failureForwardUrl("/toError");
        //        //自定义登录失败后的处理器，进行重定。
        //        //.failureHandler(new MyAuthenticationFailureHandler("/error.html"));

        http.authorizeRequests()

                //放开一些请求
                .antMatchers(
                        "/oauth/**",
                        "/login/**",
                        "/logout/**"
                ).permitAll()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .antMatchers("/login.html").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //放开所有表单提交
                .formLogin()
                .loginPage("/toLogin")
                .permitAll()
                .and()
                .csrf().disable();
    }

    private void  test() {

    }
}
