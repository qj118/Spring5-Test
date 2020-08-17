package org.demon.spring5.dao.impl;

import org.demon.spring5.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void in(String username, double money){

        String sql = "update t_account set balance = balance + ? where username = ?";
        int res = jdbcTemplate.update(sql, money, username);
        System.out.println("in ==> " + res);
    }

    public void out(String username, double money){

        String sql = "update t_account set balance = balance - ? where username = ?";
        int res = jdbcTemplate.update(sql, money, username);
        System.out.println("out ==> " + res);
    }
}
