package com.ujun;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), 8080), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/api", new ApiHandler());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            LocalTime start = LocalTime.now();
            String response = "Welcome to Simple HTTP Server!";
            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
            LocalTime end = LocalTime.now();
            System.out.println(ChronoUnit.NANOS.between(start, end) / 1_000_000F);
        }
    }

    static class ApiHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestMethod = exchange.getRequestMethod();
            String response;
            switch (requestMethod) {
                case "GET":
                    response = handleGet(exchange);
                    break;
                case "POST":
                    response = handlePost(exchange);
                    break;
                default:
                    response = "Method not supported";
            }

            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, responseBytes.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        }

        private String handleGet(HttpExchange exchange) {
            return "{\"message\": \"This is GET response\"}";
        }

        private String handlePost(HttpExchange exchange) {
            return "{\"message\": \"This is POST response\"}";
        }
    }
}