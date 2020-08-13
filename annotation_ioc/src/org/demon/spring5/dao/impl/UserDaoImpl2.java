package org.demon.spring5.dao.impl;

import org.demon.spring5.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl2 implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDaoImpl2 add method.");
    }
}
