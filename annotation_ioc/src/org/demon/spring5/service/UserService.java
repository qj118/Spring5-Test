package org.demon.spring5.service;

import org.demon.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserService {

    /**
     * 此时 UserDao 有两个实现类，如果中使用 Autowired 注解无法确定注入的是哪一个实现类的对象。
     * 需要使用 Qualifier 注解的 value 属性指定注入的属性对象：
     *      如果实现类上有 value 属性，则使用 value 属性的值；
     *      如果实现类上无 value 属性，则使用类名首字母小写。
     */
    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDao userDao;

    @Resource(name = "userDaoImpl2") // jdk1.8 可用，以后需要导入 javax.annotation 包
    private UserDao userDao2;

    @Value(value = "Demon")
    private String uName;

    public void addUser(){
        System.out.println("添加一个 User 对象: " + uName);
        userDao.add();
        userDao2.add();
    }
}
