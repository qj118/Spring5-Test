package org.demon.spring5.factorybean;

import org.demon.spring5.Book;
import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<Book> {

    @Override
    public Book getObject() throws Exception {
        Book book = new Book();
        book.setbName("外婆的道歉信");
        book.setbAuthor("弗雷德里克·巴克曼");
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
