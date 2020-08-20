package com.demon.webfluxdemo;

import com.demon.webfluxdemo.handler.BookHandler;
import com.demon.webfluxdemo.service.BookService;
import com.demon.webfluxdemo.service.impl.BookServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class Server {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    // 创建 Router 路由
    public RouterFunction<ServerResponse> routingFunction(){
        // 创建 handler 对象
        BookService bookService = new BookServiceImpl();
        BookHandler handler = new BookHandler(bookService);

        // 设置路由
        return RouterFunctions.route(
                GET("/books/{id}").and(accept(APPLICATION_JSON)), handler::getBookById)
                .andRoute(GET("/books").and(accept(APPLICATION_JSON)),handler::getAllBooks)
                .andRoute(POST("/saveBook").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), handler::saveBook);
    }

    // 创建服务器完成适配
    public void createReactorServer(){
        // 适配
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        // 创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }

}
