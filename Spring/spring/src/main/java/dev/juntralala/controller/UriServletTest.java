package dev.juntralala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UriServletTest {

    @RequestMapping
    public void test(BindingResult bindingResult) {
    }
}
