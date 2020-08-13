package org.demon.spring5.test;

import org.demon.spring5.Book;
import org.demon.spring5.bean.Dept;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

    @Test
    public void testMyBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book myBean= context.getBean("myBean", Book.class);
        System.out.println(myBean);
    }

    @Test
    public void testLife(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Dept dept = context.getBean("deptBean", Dept.class);
        System.out.println(dept);
        context.close();

    }
}
