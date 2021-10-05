package com.sy.springsecurity_oauth_jjwt_demo.restful.controller;


import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 孙宇
 * @since 2021-10-04
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.substring(header.lastIndexOf("bearer") + 7);

        return Jwts.parser()
                //设置秘钥，如果秘钥是中文的，进行一个转换
                .setSigningKey("syxx".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
    }

}
