package org.demon.spring5.dao;

public interface AccountDao {

    void in(String username, double money);

    void out(String username, double money);
}
