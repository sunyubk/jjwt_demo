package com.sy.springsecurity_oauth_jjwt_demo;

import com.sy.springsecurity_oauth_jjwt_demo.utils.MybatisPlusGeneratorUtil;
import com.sy.springsecurity_oauth_jjwt_demo.utils.param.GeneratorParam;
import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import java.util.Date;

@SpringBootTest
class SpringsecurityOauthJjwtDemoApplicationTests {

    @Test
    public void testGenerator() {
        GeneratorParam param = new GeneratorParam();
        param.setOpenBeanPathCustom(false);
        param.setTargetParentPackageName("com.sy.springsecurity_oauth_jjwt_demo.restful");

        param.setAuthor("孙宇");

        param.setDbTableList("sys_user");

        param.setDbDriverName("com.mysql.cj.jdbc.Driver");
        //param.setDbUrl("jdbc:mysql://172.16.10.223:3306/hs_leitsm_duty?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useOldAliasMetadataBehavior=true");
        param.setDbUrl("jdbc:mysql://localhost:3306/security?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useOldAliasMetadataBehavior=true");
        param.setDbUserName("root");
        param.setDbPassword("root");
        //param.setDbPassword("root");
        MybatisPlusGeneratorUtil.generator(param);
    }

    @Test
    public void encodePassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123"));
    }

    @Test
    public void getIdStr() {
        for (int i = 0; i < 20; i++) {
            System.out.println(IdWorker.getIdStr());
        }
    }

    /**
     * 签发token
     */
    @Test
    public void testJwt() {
        JwtBuilder jwtBuilder = Jwts.builder()
                //唯一ID
                .setId("888")
                //接收的用户
                .setSubject("Rose")
                //签发时间
                .setIssuedAt(new Date())
                //签名算法及秘钥，盐。
                .signWith(SignatureAlgorithm.HS256, "syxx");
                //自定义声明
                //.claim("name", "sy")
                //.claim("log", "xxx")
                //.addClaims(Map);

        //签发token
        String token = jwtBuilder.compact();
        System.out.println(token);
    }

    /**
     * 解析token
     */
    @Test
    public void testParseToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjMxMTAwMzEzfQ.3Jy4EJCL6U1S5unfyr347L0IujHWL8Jf7H8MqyyZ7gc";

        //解析token 获取Claims，jwt中荷载声明的对象
        Claims claims = (Claims) Jwts.parser()
                //签发时候的秘钥
                .setSigningKey("syxx")
                .parse(token)
                .getBody();
        System.out.println("id："+claims.getId());
        System.out.println("sub："+claims.getSubject());
        System.out.println("iat："+claims.getIssuedAt());
    }



    /**
     * 签发token（失效时间）
     */
    @Test
    public void testJwtHasExpire() {
        //当前时间
        Long date = System.currentTimeMillis();
        //失效时间
        long exp = date + 60 * 1000;

        JwtBuilder jwtBuilder = Jwts.builder()
                //唯一ID
                .setId("888")
                //接收的用户
                .setSubject("Rose")
                //签发时间
                .setIssuedAt(new Date())
                //签名算法及秘钥，盐。
                .signWith(SignatureAlgorithm.HS256, "syxx")
                //失效时间
                .setExpiration(new Date(exp));

        //签发token
        String token = jwtBuilder.compact();
        System.out.println(token);
    }

    /**
     * 解析token（失效时间）
     */
    @Test
    public void testParseTokenHasExpire() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjMxMTAwODcyLCJleHAiOjE2MzExMDA5MzJ9.A5j3BlSReM_L5tJzhs8oS12xQSgsnSqo1dN6dtGHHLA";

        //解析token 获取Claims，jwt中荷载声明的对象
        Claims claims = (Claims) Jwts.parser()
                //签发时候的秘钥
                .setSigningKey("syxx")
                .parse(token)
                .getBody();
        System.out.println("id："+claims.getId());
        System.out.println("sub："+claims.getSubject());
        System.out.println("iat："+claims.getIssuedAt());
    }
}
