package org.demon.spring5.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void registerUser(){
        System.out.println("注册新用户 ...");
    }
}
