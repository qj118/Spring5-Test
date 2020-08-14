package org.demon.spring5.dao.impl;

import org.demon.spring5.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("add 方法执行 ...");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update 方法执行 ...");
        return id;
    }
}
