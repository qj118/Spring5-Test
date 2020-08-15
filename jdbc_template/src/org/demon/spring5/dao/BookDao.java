package org.demon.spring5.dao;

import org.demon.spring5.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);

    void updateBook(Book book);

    void delete(Integer id);

    int count();

    Book getOneBook(int id);

    List<Book> getBookList();

    void batchAdd(List<Object[]> books);

    void batchUpdateBook(List<Object[]> books);

    void batchDelete(List<Object[]> ids);
}
