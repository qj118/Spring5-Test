package org.demon.spring5.test;

import org.demon.spring5.entity.Book;
import org.demon.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcTemplateTest {

    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook(new Book("射雕英雄传", "金庸"));
    }

    @Test
    public void testUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setId(1);
        book.setName("笑傲江湖");
        book.setAuthor("金庸");
        bookService.updateBook(book);
    }

    @Test
    public void testDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.deleteBook(1);
    }

    @Test
    public void testQuery(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        // 返回单个值
        System.out.println("一共有 " + bookService.bookCount() + " 本书");
        // 返回当个对象
        Book book = bookService.findOne(3);
        System.out.println(book);
        // 返回多个对象
        List<Book> books = bookService.findAll();
        System.out.println(books);
    }

    @Test
    public void testBatchAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> bookList = new ArrayList<>();
        Object[] book1 = {"谁杀了她", "东野圭吾"};
        Object[] book2 = {"白夜行", "东野圭吾" };
        Object[] book3 = {"无人生还", "阿加莎·克里斯蒂"};

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        bookService.addBooks(bookList);
    }

    @Test
    public void testBatchUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> bookList = new ArrayList<>();
        Object[] book1 = {"流星之绊", "东野圭吾", "4"};
        Object[] book2 = {"解忧杂货铺", "东野圭吾", "5" };
        Object[] book3 = {"东方快车谋杀案", "阿加莎·克里斯蒂", "6"};

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        bookService.updateBooks(bookList);
    }

    @Test
    public void testBatchDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> ids = new ArrayList<>();
        Object[] id1 = {"2"};
        Object[] id2 = {"3"};

        ids.add(id1);
        ids.add(id2);

        bookService.deleteBooks(ids);
    }
}
