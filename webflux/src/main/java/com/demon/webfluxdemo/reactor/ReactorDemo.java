package com.demon.webfluxdemo.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReactorDemo {

    public static void main(String[] args) {
        // 生成数据流, 并发送数据流
        Flux.just(1, 2, 3, 4, 5, 6, 7).subscribe(System.out::println);

        Mono.just(1).subscribe(System.out::print);

        // 其他生成数据的方式
        Integer[] array = {1, 2 , 3, 4, 5, 6, 7};
        Flux.fromArray(array);

        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list);

        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);
    }
}
