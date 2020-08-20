## 工程简介

Spring5 学习的练习笔记。
[视频教程](https://www.bilibili.com/video/BV1Vf4y127N5?p=1)

## 文件结构

### hello_world 

简单的 spring 架构实现

### xml_ioc 

xml 方式实现 IOC 对 Bean 的管理。
+ bean2.xml - factorybean 和生命周期测试。
+ bean3.xml - 自动装配测试。
+ bean4.xml - 外部属性文件的引入测试。

### annotation_ioc

注解方式实现 IOC 对 Bean 的管理。

### aop

面向切面编程简单体验。
- bean.xml 在注解方式实现 AOP操作时的包扫描配置以及开启 AspectJ 自动代理。
- bean2.xml xml配置方式实现 AOP 操作。

### jdbc_template

JdbcTemplate 对数据库增删改查的基本使用测试。

### transaction

Spring 相关事务管理操作测试。
- ApplicationContext.xml 注解方式实现事务管理；
- SpringConfig.xml xml配置方式实现事务管理。

### spring5_new

Spring5 新功能测试

### webflux

Spring webflux 模块的简单实用（该模块是 Spring boot）
- controller 包是注解编程模型
- handler 包是函数式编程模型，Server 类启动后，可启动 Client 类进行测试
