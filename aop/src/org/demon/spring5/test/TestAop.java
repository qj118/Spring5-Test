package org.demon.spring5.test;

import org.demon.spring5.annotation.Book;
import org.demon.spring5.config.AopConfig;
import org.demon.spring5.xml.Book2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void testAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = context.getBean("book", Book.class);
        book.add();
    }

    @Test
    public void testAnnotation2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        Book book = context.getBean("book", Book.class);
        book.add();
    }

    @Test
    public void testXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book2 book2 = context.getBean("book2", Book2.class);
        book2.buy();
    }
}
