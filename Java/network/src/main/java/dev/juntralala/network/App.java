package dev.juntralala.network;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import static java.nio.charset.StandardCharsets.UTF_8;

public class App {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 8080), 200);

        httpServer.createContext("/hello")
                .setHandler((exchange) -> {
                    var data = "Hello World".getBytes(UTF_8);
                    exchange.sendResponseHeaders(200, data.length);
                    var out = exchange.getResponseBody();
                    out.write(data);
                    exchange.close();
                });
        httpServer.createContext("/sapa")
                .setHandler(exchange -> {
                    if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                        String name = new String(exchange.getRequestBody().readAllBytes());
                        var data = ("Hai " + name).getBytes(UTF_8);
                        exchange.sendResponseHeaders(200, data.length);
                        exchange.getResponseBody().write(data);
                        exchange.close();
                    } else {
                        exchange.sendResponseHeaders(405, 0);
                        exchange.close();
                    }
                });

        httpServer.start();
        System.out.println("server running: " + httpServer.getAddress().getHostString() + ":" + httpServer.getAddress().getPort());
    }
}
