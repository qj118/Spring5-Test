package org.demon.spring5.test;

import org.demon.spring5.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class JTest4 {

    @Autowired
    private UserService userService;

    @Test
    public void testJUnit4(){
        userService.registerUser();
    }
}
