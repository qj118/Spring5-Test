package com.demon.webfluxdemo.service.impl;

import com.demon.webfluxdemo.entity.Book;
import com.demon.webfluxdemo.service.BookService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookServiceImpl implements BookService {

    // 模拟数据库
    private final Map<Integer, Book> books = new HashMap<>();

    public BookServiceImpl() {
        this.books.put(1, new Book("流星之绊", "东野圭吾"));
        this.books.put(2, new Book("解忧杂货铺", "东野圭吾"));
        this.books.put(3, new Book("东方快车谋杀案", "阿加莎·克里斯蒂"));
    }

    @Override
    public Mono<Book> getBookById(int id) {
        return Mono.justOrEmpty(this.books.get(id));
    }

    @Override
    public Flux<Book> getAllBook() {
        return Flux.fromIterable(this.books.values());
    }

    @Override
    public Mono<Void> saveBookInfo(Mono<Book> bookMono) {
        // doOnNext 即取出 Mono 中封装的数据，进行进一步的操作
        return bookMono.doOnNext( book -> {
            int id = books.size() + 1;
            books.put(id, book);
        }).thenEmpty(Mono.empty());
    }
}
