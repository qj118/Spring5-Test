package com.demon.webfluxdemo.controller;

import com.demon.webfluxdemo.entity.Book;
import com.demon.webfluxdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{id}")
    public Mono<Book> getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @GetMapping("/book")
    public Flux<Book> getBooks(){
        return bookService.getAllBook();
    }

    @PostMapping("/savebook")
    public Mono<Void> saveBook(@RequestBody Book book){
        Mono<Book> bookMono = Mono.just(book);
        return bookService.saveBookInfo(bookMono);

    }
}
