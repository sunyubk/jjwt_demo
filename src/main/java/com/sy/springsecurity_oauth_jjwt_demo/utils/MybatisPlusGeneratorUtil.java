package com.sy.springsecurity_oauth_jjwt_demo.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.sy.springsecurity_oauth_jjwt_demo.consts.Const;
import com.sy.springsecurity_oauth_jjwt_demo.utils.param.GeneratorParam;
import io.micrometer.core.instrument.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by [张渊]
 * 19-5-14 下午5:46
 */
public abstract class MybatisPlusGeneratorUtil {

    private final static String PROJECT_PATH = System.getProperty("user.dir");

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    /**
     * @param param 生成代码参数
     */
    public static void generator(GeneratorParam param) {
        // 代码生成器
        AutoGenerator mpg = defaultAutoGenerator(param);
        mpg.execute();
    }

    public static void generatorCustomBean(final GeneratorParam param) {
        // 代码生成器
        final AutoGenerator mpg = defaultAutoGenerator(param);

        if (param.getOpenBeanPathCustom()) {
            List<FileOutConfig> focList = mpg.getCfg().getFileOutConfigList();
            focList.add(new FileOutConfig(param.getEntityFileOutConfigTemplatePath()) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    String javaSourcePath = "/src/main/java/";
                    return param.getBeanModelPath() + javaSourcePath + param.getBeanPackagePath()
                            + Const.FILE_SEPARATOR + tableInfo.getEntityName() + StringPool.DOT_JAVA;
                }
            });

            mpg.getTemplate().setEntity(null);

            PackageConfig pc = mpg.getPackageInfo();
            pc.setParent(param.getTargetParentPackageName());

//            pc.setEntity(param.getBeanPackageName());
//            pc.setMapper("mapper");
//            pc.setService("service");
//            pc.setServiceImpl("service.impl");
//            pc.setController("controller");
//            pc.setXml("mapper");
            mpg.setPackageInfo(pc);
        }

        mpg.execute();
    }


    /**
     * @param param 生成代码参数
     */
    public static AutoGenerator defaultAutoGenerator(GeneratorParam param) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        if (param != null) {
            // 全局配置
            GlobalConfig gc = defaultGlobalConfig(param);
            mpg.setGlobalConfig(gc);

            // 数据源配置
            DataSourceConfig dsc = defaultDataSourceConfig(param);
            mpg.setDataSource(dsc);

            // 包路径配置
            PackageConfig pc = defaultPackageConfig(param);
            mpg.setPackageInfo(pc);

            // 自定义配置
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };

            // 自定义XML输出配置
//            List<FileOutConfig> focList = defaultXmlFileOutConfig(pc, param);
//            cfg.setFileOutConfigList(focList);
//            mpg.setCfg(cfg);

            // 配置模板
//            TemplateConfig templateConfig = defaultTemplateConfig(param);
//            mpg.setTemplate(templateConfig);

            // 策略配置
            StrategyConfig strategy = defaultStrategyConfig(pc, param);
            mpg.setStrategy(strategy);

            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        }
        return mpg;
    }


    /**
     * 默认全局配置
     */
    private static GlobalConfig defaultGlobalConfig(GeneratorParam param) {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = PROJECT_PATH;
        gc.setAuthor(param.getAuthor());

        projectPath += StringUtils.isBlank(param.getTargetModelName()) ? "" : "/" + param.getTargetModelName();
        // 生成导出地址
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(param.getFileOverride());// 文件覆盖
        gc.setIdType(IdType.UUID);// 主键策略
        gc.setOpen(false);
        gc.setServiceName("%sService");// 设置生成的service接口的名字的首字母是否为I
        gc.setSwagger2(true); // 实体属性 Swagger2 注解
        gc.setBaseResultMap(true);// 生成基础映射
        gc.setBaseColumnList(true);// 生成基础SQL片段

        return gc;
    }


    /**
     * 默认数据源配置
     */
    private static DataSourceConfig defaultDataSourceConfig(GeneratorParam param) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(param.getDbType());// 数据库类型
        dsc.setDriverName(param.getDbDriverName());
        dsc.setUrl(param.getDbUrl());
        // dsc.setSchemaName("public");
        dsc.setUsername(param.getDbUserName());
        dsc.setPassword(param.getDbPassword());
        return dsc;
    }


    /**
     * 默认包路径配置
     */
    private static PackageConfig defaultPackageConfig(GeneratorParam param) {
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(param.getDbModelName());// 模块名，用于生成表的前缀，如：sys_user中的sys
        pc.setParent(param.getTargetParentPackageName());
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        pc.setEntity("beans");
        pc.setXml("mapper");
        return pc;
    }


    /**
     * XML 自定义配置会被优先输出配置
     */
    private static List<FileOutConfig> defaultXmlFileOutConfig(final PackageConfig pc, GeneratorParam param) {
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(param.getMapperXmlFileOutConfigTemplatePath()) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PROJECT_PATH + "/src/main/resources/mybatis/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        return focList;
    }


    /**
     * 默认配置模板
     */
    private static TemplateConfig defaultTemplateConfig(GeneratorParam param) {
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity(param.getEntityTemplatePath());
        templateConfig.setMapper(param.getMapperTemplatePath());
        templateConfig.setService(param.getServiceTemplatePath());
        templateConfig.setServiceImpl(param.getServiceImplTemplatePath());
        templateConfig.setController(param.getControllerTemplatePath());
        templateConfig.setXml(null);
        return templateConfig;
    }


    /**
     * 策略配置
     */
    private static StrategyConfig defaultStrategyConfig(PackageConfig pc, GeneratorParam param) {
        StrategyConfig strategy = new StrategyConfig();

        // 全局大写命名
        strategy.setCapitalMode(true);

        // 逻辑删除字段
        strategy.setLogicDeleteFieldName(param.getDeleteField());

        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

//        strategy.setSuperEntityClass("com.baomidou.ant.basic.BaseEntity");

        strategy.setEntityLombokModel(true);// 使用lombok
        strategy.setRestControllerStyle(true);

//        strategy.setSuperControllerClass("com.baomidou.ant.basic.BaseController");

        // 生成的表
        strategy.setInclude(param.getDbTableList().split(","));

//        strategy.setSuperEntityColumns("id");

        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setSuperEntityClass(param.getSuperEntityClass());
        strategy.setSuperControllerClass(param.getSuperControllerClass());
        return strategy;
    }


    /**
     * 默认配置模板
     */
    private static TemplateConfig customBeanTemplateConfig(TemplateConfig templateConfig, GeneratorParam param) {
        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity(null);
        return templateConfig;
    }
}
