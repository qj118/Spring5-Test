package com.demon.webfluxdemo.handler;

import com.demon.webfluxdemo.entity.Book;
import com.demon.webfluxdemo.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BookHandler {

    private final BookService bookService;

    public BookHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public Mono<ServerResponse> getBookById(ServerRequest request){
        int bookId = Integer.valueOf(request.pathVariable("id"));
        // 处理没有查询到的情况
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Book> bookMono = this.bookService.getBookById(bookId);
        // 返回流
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(bookMono, Book.class).switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> getAllBooks(ServerRequest request){
        Flux<Book> books = this.bookService.getAllBook();

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(books, Book.class);
    }

    public Mono<ServerResponse> saveBook(ServerRequest request){

        Mono<Book> bookMono = request.bodyToMono(Book.class);

        return ServerResponse.ok().build(this.bookService.saveBookInfo(bookMono));
    }
}
