package org.demon.spring5.dao.impl;

import org.demon.spring5.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("UserDaoImpl add method.");
    }
}
