package com.sy.springsecurity_oauth_jjwt_demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AuthorizationServerConfig
 * @Description TODO 认证授权服务器
 * @Author sy
 * @Date 2021/9/7 20:41
 * @Version 1.0
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private TokenStore jwtTokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private JwtTokenEnhancer jwtTokenEnhancer;



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //放在内存中
        clients.inMemory()
                //clientId
                .withClient("client")
                //秘钥
                .secret(passwordEncoder.encode("123"))
                //范围
                .scopes("all")
                //授权类型，授权码模式，密码模式，刷新令牌
                .authorizedGrantTypes("authorization_code","password","refresh_token")
                //accessToken 失效时间
                .accessTokenValiditySeconds(60)
                //刷新令牌过期时间
                .refreshTokenValiditySeconds(86400)
                //自动授权
                .autoApprove(true)
                //重定向地址，通过重定向地址获取授权码，定向到哪里无所谓，重要的是拿到的授权码
                //.redirectUris("http://www.baidu.com");
                //重定向到 sso 测试的 oauth2_client01_demo 项目中
                .redirectUris("http://localhost:8080/login");
    }

    /**
     * 密码模式
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        //设置 JWT 增强内容
        TokenEnhancerChain chain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer);
        delegates.add(jwtAccessTokenConverter);
        chain.setTokenEnhancers(delegates);

        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                //token 存入redis。 如果使用 jwt 令牌不要存储令牌，所以注释掉
                //.tokenStore(redisTokenStore());
                //accessToken 转成 JWTtoken
                .tokenStore(jwtTokenStore)
                .accessTokenConverter(jwtAccessTokenConverter)
                //JWT增强内容
                .tokenEnhancer(chain);
    }

    //因为 jwt 令牌是无状态的，所以不需要存储，所以不需要这里
    //@Bean
    //public TokenStore redisTokenStore() {
    //    return new RedisTokenStore(redisConnectionFactory);
    //}


    //单独配置了，所以不在这里配置了
    //@Bean
    //public TokenStore jwtTokenStore() {
    //    return new JwtTokenStore(jwtAccessTokenConverter());
    //}
    //
    //@Bean
    //public JwtAccessTokenConverter jwtAccessTokenConverter() {
    //    JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
    //    //设置 jwt 秘钥
    //    jwtAccessTokenConverter.setSigningKey("test");
    //    return jwtAccessTokenConverter;
    //}


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //获取秘钥必须要身份认证，单点登录必须要配置
        security.tokenKeyAccess("isAuthenticated()");
    }
}
