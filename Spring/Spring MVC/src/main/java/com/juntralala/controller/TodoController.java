package com.juntralala.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class TodoController {

    private List<String> todos = new ArrayList<>();

    @GetMapping(path = "/todos", produces = APPLICATION_JSON_VALUE)
    public List<String> getTodo() {
        return todos;
    }

    @PostMapping(path = "/todos", produces = APPLICATION_JSON_VALUE)
    public List<String> addTodo(@RequestParam("todo") String todo) {
        todos.add(todo);
        return todos;
    }

}
