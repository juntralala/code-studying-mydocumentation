package dev.juntralala.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@Controller
public class IndexController {

    @GetMapping(value = "/", produces = {TEXT_HTML_VALUE})
    @ResponseBody
    public String index(HttpServletRequest request) {
        return "Welcom to my world " + request.getSession().getId();
    }
}
