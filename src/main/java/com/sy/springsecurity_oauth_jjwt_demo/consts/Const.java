package com.sy.springsecurity_oauth_jjwt_demo.consts;

/**
 * Created by [张渊]
 * 2019/12/3 11:01
 */
public interface Const {

    /**
     * 文件分隔符
     */
    String FILE_SEPARATOR = System.getProperty("file.separaor");

    /**
     * 默认的父ID
     */
    String DEFAULT_PARENT_ID = "-1";

    /**
     * 角色前缀
     */
    String ROLE = "ROLE_";

    /**
     * 路由前缀
     */
    String ROUTER = "ROUTER_";

    /**
     * 时间格式化表达式
     */
    String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * IP分类类型
     */
    interface IpType {
        /**
         * IP
         */
        Integer IP_SINGLE = 0;

        /**
         * IP段
         */
        Integer IP_RANGE = 1;
    }

    /**
     * 客户端是否请求
     */
    interface ClientRequest {
        /**
         * 客户端已经请求过参数
         */
        Integer IS_REQUEST = 1;

        /**
         * 客户端没有请求过
         */
        Integer NOT_REQUEST = 0;
    }

    interface SysParam {
        /**
         * 登录服务IPKEY
         */
        String LOGIN_SERVER_IP = "LOGIN_SERVER_IP";
        /**
         * 登录服务名KEY
         */
        String LOGIN_SERVER_NAME = "LOGIN_SERVER_NAME";
        /**
         * 登录用户名KEY
         */
        String LOGIN_USER_NAME = "LOGIN_USER_NAME";
        /**
         * 登录密码KEY
         */
        String LOGIN_PASSWORD = "LOGIN_PASSWORD";
        /**
         * 登录超时时间KEY
         */
        String LOGIN_TIMEOUT = "LOGIN_TIMEOUT";
        /**
         * 登录重试次数KEY
         */
        String LOGIN_RETRY_TIME = "LOGIN_RETRY_TIME";

        /**
         * 模拟登录成功后超时时间KEY
         */
        String LOGIN_SUCCESS_TIMEOUT = "LOGIN_SUCCESS_TIMEOUT";

        /**
         * 是否为测试登录（是）
         */
        String IS_MOCK = "IS_MOCK";

        /**
         * 测试登录结果
         */
        String MOCK_RESULT = "MOCK_RESULT";
    }

    interface CacheKeys {
        /**
         * 登录成功key
         */
        String LOGIN_SUCCESS_KEY = "LOGIN_SUCCESS_KEY";
    }

    /**
     * 资源类型
     */
    interface PermissionType {

        /**
         * 菜单
         */
        Integer MENU = 0;

        /**
         * 按钮
         */
        Integer BTN = 1;

        /**
         * 顶菜单
         */
        Integer TOP_MENU = 2;

    }
}
