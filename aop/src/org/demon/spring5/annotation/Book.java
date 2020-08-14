package org.demon.spring5.annotation;

import org.springframework.stereotype.Component;

@Component
public class Book {
    public void add(){
        //int i = 10/0;
        System.out.println("新增一本书 ...");
    }
}
