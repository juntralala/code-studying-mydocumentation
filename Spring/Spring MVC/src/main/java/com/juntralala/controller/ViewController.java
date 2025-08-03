package com.juntralala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ViewController {

    @GetMapping("/web/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false) String name) {
        if (name == null) {
            return new ModelAndView("redirect:/web/hello?name=Guest");
        }

        return new ModelAndView("hello", Map.of(
                "title", "Belajar View",
                "name", name
        ));
    }

}
