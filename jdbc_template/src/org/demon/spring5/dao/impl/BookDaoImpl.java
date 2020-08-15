package org.demon.spring5.dao.impl;

import org.demon.spring5.dao.BookDao;
import org.demon.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {

        String sql = "insert into t_book (name, author) values(?, ?)";
        Object[] args = {book.getName(), book.getAuthor()};

        int result = jdbcTemplate.update(sql, args);
        System.out.println(result);
    }

    @Override
    public void updateBook(Book book) {

        String sql = "update t_book set name = ?, author = ? where id = ?";
        Object[] args = { book.getName(), book.getAuthor(), book.getId() };
        int result = jdbcTemplate.update(sql, args);
        System.out.println(result);
    }

    @Override
    public void delete(Integer id) {

        String sql = "delete from t_book where id = ?";
        int result = jdbcTemplate.update(sql, id);
        System.out.println(result);
    }

    @Override
    public int count() {

        String sql = "select count(*) from t_book";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book getOneBook(int id) {

        String sql = "select * from t_book where id = ?";
        // BeanPropertyRowMapper 将查询出来的数据封装到指定的对象类型中。
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> getBookList() {

        String sql = "select * from t_book";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return books;
    }

    @Override
    public void batchAdd(List<Object[]> books) {
        String sql = "insert into t_book(name, author) values(?, ?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, books);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> books) {
        String sql = "update t_book set name = ?, author = ? where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, books);
        System.out.println(Arrays.toString(ints));

    }

    @Override
    public void batchDelete(List<Object[]> ids) {
        String sql = "delete from t_book where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, ids);
        System.out.println(Arrays.toString(ints));
    }
}
