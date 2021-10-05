package com.sy.springsecurity_oauth_jjwt_demo.utils.param;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * 自动生成代码属性封装
 * <p>
 * Created by [张渊]
 * 2019/5/15 10:47
 */
public class GeneratorParam {

    private final String suffix = ".ftl";

    /**
     * 开启 beans 目录自定义，默认false
     */
    private boolean openBeanPathCustom = false;

    /**
     * 在使用 main 方法调用时会需要
     * 需要将 Mapper、Service、ServiceImpl、Mapper.xml 生成到哪个模块下，需要模块名
     * 例如：lcm-am-server
     */
    private String targetModelName = "";

    /**
     * 自定义包名，在 Controller Service Service.impl Mapper 包名后追加。
     */
    private String customAfterPackageName;

    /**
     * 需要将 Mapper、Service、ServiceImpl、Mapper.xml 生成到哪个包下，指定其包的父级包名
     * 注意：该属性只能是包名，不能是路径
     * 例如：com.le.lcm.am
     */
    private String targetParentPackageName;

    /**
     * 是否覆盖文件
     */
    private boolean fileOverride = true;


    /**
     * 逻辑删除字段名
     */
    private String deleteField = "del";


    /**
     * 数据库表模块前缀名称
     * 例如：sys_user 中的 sys
     */
    private String dbModelName = "";


    /**
     * 要生成代码的数据库表名
     */
    private String dbTableList;


    /**
     * 作者，也就是注释中的创建人
     */
    private String author;

    /**
     * 自定义继承的Entity类全称，带包名
     */
    private String superEntityClass;


    /**
     * Entity 实体类模板文件路径
     */
    private String entityTemplatePath = "/templates/entity.java";


    /**
     * Entity 自定义输出路径模板
     */
    private String entityFileOutConfigTemplatePath = entityTemplatePath + suffix;


    /**
     * 自定义继承的Controller类全称，带包名
     */
    private String superControllerClass;


    /**
     * Controller 控制层模板文件路径
     */
    private String controllerTemplatePath = "/templates/controller.java";


    /**
     * Controller 自定义输出路径模板
     */
    private String controllerFileOutConfigTemplatePath = controllerTemplatePath + suffix;


    /**
     * Service 服务层模板文件路径
     */
    private String serviceTemplatePath = "/templates/service.java";


    /**
     * Service 自定义输出路径模板
     */
    private String serviceFileOutConfigTemplatePath = serviceTemplatePath + suffix;


    /**
     * ServiceImpl 服务层实现模板文件路径
     */
    private String serviceImplTemplatePath = "/templates/serviceImpl.java";


    /**
     * ServiceImpl 自定义输出路径模板
     */
    private String serviceImplFileOutConfigTemplatePath = serviceImplTemplatePath + suffix;


    /**
     * Mapper.xml 模板文件路径
     */
    private String mapperXmlTemplatePath = "/templates/mapper.xml";


    /**
     * Mapper.xml 文件自定义输出路径模板
     */
    private String mapperXmlFileOutConfigTemplatePath = "/templates/mapper.xml.ftl";


    /**
     * mapper 持久层模板文件路径
     */
    private String mapperTemplatePath = "/templates/mapper.java";


    /**
     * 依赖 mybatis-plus
     * 数据库类型，默认 mariadb
     */
    private DbType dbType = DbType.MARIADB;

    /**
     * 数据库驱动
     */
    private String dbDriverName;


    /**
     * 数据库 URL
     */
    private String dbUrl;


    /**
     * 数据库用户名
     */
    private String dbUserName;


    /**
     * 数据库密码
     */
    private String dbPassword;


    /**
     * 需要将 Bean 生成到哪个模块下，需要模块名(有可能 Bean 和 Mapper、Service 等分开的)
     * 注意：如果该属性为 null，则将 Bean 生成到 targetModelName 项目模块下
     * 例如：lcm-beans
     */
    private String beanModelName;


    /**
     * Bean 模块的路径
     */
    private String beanModelPath;


    /**
     * Bean 包名，在单独生成 Bean 文件到其他模块时使用
     * 包名为：publicParentPackageName + beanPackageName
     */
    private String beanPackageName;


    /**
     * 实体类的包路径，需要将实体类存放在哪个包路径下，必须是路径，不能是 com.le 包名
     * 注意：beanTargetModelName 为 null 时该属性不生效，会将文件生成到 targetModelName 下的指定父级包中
     * 例如：com/le/lcm/beans
     */
    private String beanPackagePath;


    public boolean getOpenBeanPathCustom() {
        return openBeanPathCustom;
    }

    public void setOpenBeanPathCustom(boolean openBeanPathCustom) {
        this.openBeanPathCustom = openBeanPathCustom;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getCustomAfterPackageName() {
        return customAfterPackageName;
    }

    public void setCustomAfterPackageName(String customAfterPackageName) {
        this.customAfterPackageName = customAfterPackageName;
    }

    public String getTargetModelName() {
        return targetModelName;
    }

    public void setTargetModelName(String targetModelName) {
        this.targetModelName = targetModelName;
    }

    public String getTargetParentPackageName() {
        return targetParentPackageName;
    }

    public void setTargetParentPackageName(String targetParentPackageName) {
        this.targetParentPackageName = targetParentPackageName;
    }

    public boolean getFileOverride() {
        return fileOverride;
    }

    public void setFileOverride(boolean fileOverride) {
        this.fileOverride = fileOverride;
    }

    public String getDeleteField() {
        return deleteField;
    }

    public void setDeleteField(String deleteField) {
        this.deleteField = deleteField;
    }

    public String getDbModelName() {
        return dbModelName;
    }

    public void setDbModelName(String dbModelName) {
        this.dbModelName = dbModelName;
    }

    public String getDbTableList() {
        return dbTableList;
    }

    public void setDbTableList(String dbTableList) {
        this.dbTableList = dbTableList;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSuperEntityClass() {
        return superEntityClass;
    }

    public void setSuperEntityClass(String superEntityClass) {
        this.superEntityClass = superEntityClass;
    }

    public String getEntityTemplatePath() {
        return entityTemplatePath;
    }

    public void setEntityTemplatePath(String entityTemplatePath) {
        this.entityTemplatePath = entityTemplatePath;
    }

    public String getEntityFileOutConfigTemplatePath() {
        return entityFileOutConfigTemplatePath;
    }

    public void setEntityFileOutConfigTemplatePath(String entityFileOutConfigTemplatePath) {
        this.entityFileOutConfigTemplatePath = entityFileOutConfigTemplatePath;
    }

    public String getSuperControllerClass() {
        return superControllerClass;
    }

    public void setSuperControllerClass(String superControllerClass) {
        this.superControllerClass = superControllerClass;
    }

    public String getControllerTemplatePath() {
        return controllerTemplatePath;
    }

    public void setControllerTemplatePath(String controllerTemplatePath) {
        this.controllerTemplatePath = controllerTemplatePath;
    }

    public String getControllerFileOutConfigTemplatePath() {
        return controllerFileOutConfigTemplatePath;
    }

    public void setControllerFileOutConfigTemplatePath(String controllerFileOutConfigTemplatePath) {
        this.controllerFileOutConfigTemplatePath = controllerFileOutConfigTemplatePath;
    }

    public String getServiceTemplatePath() {
        return serviceTemplatePath;
    }

    public void setServiceTemplatePath(String serviceTemplatePath) {
        this.serviceTemplatePath = serviceTemplatePath;
    }

    public String getServiceFileOutConfigTemplatePath() {
        return serviceFileOutConfigTemplatePath;
    }

    public void setServiceFileOutConfigTemplatePath(String serviceFileOutConfigTemplatePath) {
        this.serviceFileOutConfigTemplatePath = serviceFileOutConfigTemplatePath;
    }

    public String getServiceImplTemplatePath() {
        return serviceImplTemplatePath;
    }

    public void setServiceImplTemplatePath(String serviceImplTemplatePath) {
        this.serviceImplTemplatePath = serviceImplTemplatePath;
    }

    public String getServiceImplFileOutConfigTemplatePath() {
        return serviceImplFileOutConfigTemplatePath;
    }

    public void setServiceImplFileOutConfigTemplatePath(String serviceImplFileOutConfigTemplatePath) {
        this.serviceImplFileOutConfigTemplatePath = serviceImplFileOutConfigTemplatePath;
    }

    public String getMapperXmlTemplatePath() {
        return mapperXmlTemplatePath;
    }

    public void setMapperXmlTemplatePath(String mapperXmlTemplatePath) {
        this.mapperXmlTemplatePath = mapperXmlTemplatePath;
    }

    public String getMapperXmlFileOutConfigTemplatePath() {
        return mapperXmlFileOutConfigTemplatePath;
    }

    public void setMapperXmlFileOutConfigTemplatePath(String mapperXmlFileOutConfigTemplatePath) {
        this.mapperXmlFileOutConfigTemplatePath = mapperXmlFileOutConfigTemplatePath;
    }

    public String getMapperTemplatePath() {
        return mapperTemplatePath;
    }

    public void setMapperTemplatePath(String mapperTemplatePath) {
        this.mapperTemplatePath = mapperTemplatePath;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    public String getDbDriverName() {
        return dbDriverName;
    }

    public void setDbDriverName(String dbDriverName) {
        this.dbDriverName = dbDriverName;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getBeanModelName() {
        return beanModelName;
    }

    public void setBeanModelName(String beanModelName) {
        this.beanModelName = beanModelName;
    }

    public String getBeanModelPath() {
        return beanModelPath;
    }

    public void setBeanModelPath(String beanModelPath) {
        this.beanModelPath = beanModelPath;
    }

    public String getBeanPackageName() {
        return beanPackageName;
    }

    public void setBeanPackageName(String beanPackageName) {
        this.beanPackageName = beanPackageName;
    }

    public String getBeanPackagePath() {
        return beanPackagePath;
    }

    public void setBeanPackagePath(String beanPackagePath) {
        this.beanPackagePath = beanPackagePath;
    }

}
