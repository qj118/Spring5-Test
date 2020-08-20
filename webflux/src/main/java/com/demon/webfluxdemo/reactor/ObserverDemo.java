package com.demon.webfluxdemo.reactor;

import java.util.Observable;

public class ObserverDemo extends Observable {

    public static void main(String[] args) {
        ObserverDemo observer = new ObserverDemo();
        // 注册两个观察者
        observer.addObserver((o, arg) -> {
            System.out.println("发生变化 ...");
        });
        observer.addObserver((o, arg) -> {
            System.out.println("真的发生变化了 ...");
        });

        // 模拟数据变化
        observer.setChanged();
        // 通知所有观察者
        observer.notifyObservers();
    }
}
