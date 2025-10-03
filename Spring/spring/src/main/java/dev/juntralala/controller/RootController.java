package dev.juntralala.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Objects;

@Controller
public class RootController implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(@NonNull String name) {
        Objects.requireNonNull(name);
        this.beanName = name;
    }

    @GetMapping
    @ResponseBody
    public String root() {
        return Thread.currentThread().getName();
    }

    @GetMapping("/hello/beanname")
    public void hello(HttpEntity<Void> http, HttpServletResponse response) throws IOException {
        response.setHeader("X-Meta", "oh my hello");
        var writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));

        writer.write("Hello " + beanName);
        writer.flush();
    }
}
