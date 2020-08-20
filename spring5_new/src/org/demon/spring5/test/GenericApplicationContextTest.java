package org.demon.spring5.test;

import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

public class GenericApplicationContextTest {

    @Test
    public void testGenericApplicationContext(){
        // 创建对象
        GenericApplicationContext context = new GenericApplicationContext();
        // 调用 context 方法注册对象
        context.refresh();
        context.registerBean("user", User.class, () -> new User());
        // 获取注册的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);

    }
}
