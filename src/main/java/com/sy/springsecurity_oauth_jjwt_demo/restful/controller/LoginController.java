package com.sy.springsecurity_oauth_jjwt_demo.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author sy
 * @Date 2021/9/6 9:59
 * @Version 1.0
 **/
@Controller
//@RequestMapping("/login")
public class LoginController {

    /**
     * 登录成功后的页面
     * @return String
     */
    @RequestMapping("/toMain")
    public String toMain() {
        return "redirect:main.html";
    }

    /**
     * 登录失败后的页面
     * @return String
     */
    @RequestMapping("/toError")
    public String toError() {
        return "redirect:error.html";
    }


    @RequestMapping("/showLogin")
    public String showLogin() {
        return "login";
    }
}
