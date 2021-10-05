package com.sy.springsecurity_oauth_jjwt_demo.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sy.springsecurity_oauth_jjwt_demo.restful.mapper")
public class MybatisPlusConfig {



    /**
     * 乐观锁插件 MP3.3.0之后更改
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor optimisticLockerInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }


    ///**
    // * 分页插件
    // * @return
    // */
    //@Bean
    //public PaginationInterceptor paginationInterceptor() {
    //    return new PaginationInterceptor();
    //}

    //@Bean
    //public SqlExplainInterceptor sqlExplainInterceptor() {
    //    SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
    //    List<ISqlParser> sqlParserList = new ArrayList<>();
    //    sqlParserList.add(new BlockAttackSqlParser());
    //    sqlExplainInterceptor.setSqlParserList(sqlParserList);
    //    return sqlExplainInterceptor;
    //}

    //@Bean
    //public MybatisPlusInterceptor mybatisPlusInterceptor(){
    //    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    //
    //    List<InnerInterceptor> list = new ArrayList<>();
    //    list.add(new BlockAttackInnerInterceptor());
    //    interceptor.setInterceptors(list);
    //    interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor()); // 乐观锁插件
    //    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    //    return interceptor;
    //}

    //@Bean
    //public OptimisticLockerInterceptor optimisticLockerInterceptor() {
    //    return new OptimisticLockerInterceptor();
    //}

}