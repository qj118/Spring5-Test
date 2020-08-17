package org.demon.spring5.service;

import org.demon.spring5.dao.BookDao;
import org.demon.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.add(book);
    }

    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

    public void deleteBook(Integer id){
        bookDao.delete(id);
    }

    public int bookCount(){
        return bookDao.count();
    }

    public Book findOne(int id){
        return bookDao.getOneBook(id);
    }

    public List<Book> findAll(){
        return bookDao.getBookList();
    }

    public void addBooks(List<Object[]> books){
        bookDao.batchAdd(books);
    }

    public void updateBooks(List<Object[]> books){
        bookDao.batchUpdateBook(books);
    }

    public void deleteBooks(List<Object[]> ids){
        bookDao.batchDelete(ids);
    }
}
