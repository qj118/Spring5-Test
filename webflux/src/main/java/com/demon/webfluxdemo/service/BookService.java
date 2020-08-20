package com.demon.webfluxdemo.service;

import com.demon.webfluxdemo.entity.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Mono<Book> getBookById(int id);

    Flux<Book> getAllBook();

    Mono<Void> saveBookInfo(Mono<Book> book);
}
