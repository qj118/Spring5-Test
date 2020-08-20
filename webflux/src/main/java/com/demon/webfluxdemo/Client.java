package com.demon.webfluxdemo;

import com.demon.webfluxdemo.entity.Book;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Client {

    public static void main(String[] args) {
        WebClient webClient  = WebClient.create("http://127.0.0.1:58443");

        // 获取某本书的信息
        String id = "1";
        Book result = webClient.get().uri("/books/{id}", id)
                      .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Book.class).block();
        System.out.println(result);

        // 新增
        Book book = new Book("山海经", "无名氏");
        Mono<Book> bookMono = Mono.just(book);
        Mono<Void> res = webClient.post().uri("/saveBook").body(bookMono, Book.class)
                         .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Void.class);
        res.doOnNext(System.out::println).block();

        // 获取全部书的信息
        Flux<Book> results = webClient.get().uri("/books")
                             .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(Book.class);
        results.map(b -> b.getName()).buffer().doOnNext(System.out::println).blockFirst();
    }
}
