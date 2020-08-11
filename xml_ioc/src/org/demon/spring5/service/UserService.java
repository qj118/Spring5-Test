package org.demon.spring5.service;

import org.demon.spring5.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("UserService add method ...");
        userDao.update();
    }
}
