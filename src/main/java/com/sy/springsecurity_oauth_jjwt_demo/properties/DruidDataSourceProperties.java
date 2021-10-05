package com.sy.springsecurity_oauth_jjwt_demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Druid 数据源参数
 * <p>
 * Created by [wlw_918]
 * 19-4-20 上午11:51
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceProperties {

    /**
     * 初始化数量
     */
    private int initialSize = 5;


    /**
     * 最小数量
     */
    private int minIdle = 5;


    /**
     * 最大活跃数
     */
    private int maxActive = 20;


    /**
     * 获取连接等待超时的最大时间
     */
    private int maxWait = 60000;


    /**
     * 间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     */
    private int timeBetweenEvictionRunsMillis = 60000;


    /**
     * 一个连接在池中最小生存的时间，单位是毫秒
     */
    private int minEvictableIdleTimeMillis = 300000;


    /**
     * 测试连接
     */
    private String validationQuery = "SELECT 1 FROM DUAL";


    /**
     * 申请连接的时候检测，建议配置为true，不影响性能，并且保证安全性
     */
    private boolean testWhileIdle = true;


    /**
     * 获取连接时执行检测，建议关闭，影响性能
     */
    private boolean testOnBorrow;


    /**
     * 归还连接时执行检测，建议关闭，影响性能
     */
    private boolean testOnReturn;


    /**
     * 合并多个 DruidDataSource 的监控数据
     */
    private boolean useGlobalDataSourceStat = true;


    /**
     * 打开PSCache，并且指定每个连接PSCache的大小
     * 是否开启PSCache，PSCache对支持游标的数据库性能提升巨大，oracle建议开启，mysql下建议关闭
     */
    private boolean poolPreparedStatements;


    /**
     * 开启 poolPreparedStatements 后生效
     */
    private int maxPoolPreparedStatementPerConnectionSize = 20;


    /**
     * 通过 connectionProperties 属性来打开mergeSql功能；慢SQL记录
     *
     * druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
     */
    private String connectionProperties = "druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000";


    /**
     * 监控统计拦截的 filters，去掉后监控界面 sql 无法统计，'wall'用于防火墙
     * 扩展插件，常用的插件有=>stat:监控统计  log4j:日志  wall:防御sql注入
     * stat,wall,log4j
     */
    private String filters = "stat,wall";


    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public boolean getUseGlobalDataSourceStat() {
        return useGlobalDataSourceStat;
    }

    public void setUseGlobalDataSourceStat(boolean useGlobalDataSourceStat) {
        this.useGlobalDataSourceStat = useGlobalDataSourceStat;
    }

    public boolean getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public int getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    public String getConnectionProperties() {
        return connectionProperties;
    }

    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }
}
