package org.demon.spring5.test;

import org.demon.spring5.config.TxConfig;
import org.demon.spring5.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransaction {

    @Test
    public void testTransfer(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        AccountService service = context.getBean("accountService", AccountService.class);
        service.transfer(100, "Fei", "Jia");
    }

    @Test
    public void testTransferByXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        AccountService service = context.getBean("account", AccountService.class);
        service.transfer(100, "Fei", "Jia");
    }

    @Test
    public void testTransferByAnnotation(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        AccountService service = context.getBean("accountService", AccountService.class);
        service.transfer(100, "Jia", "Fei");
    }
}
