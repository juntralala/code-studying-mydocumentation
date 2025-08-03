package com.juntralala.controller;

import com.juntralala.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Scanner;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HelloController {

    private HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

//    @RequestMapping(path = "/hello", method = {GET})
    @GetMapping(path = "/hello")                        // <- shortcut annotation
    public void helloWorld(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(name = "name", required = false) String name) throws IOException {
        response.setHeader("Content-Type", "text/html");
        String responseBody = helloService.hello(name);
        response.getWriter().print(responseBody);
    }
}
