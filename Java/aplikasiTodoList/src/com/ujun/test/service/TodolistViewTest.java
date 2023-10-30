package com.ujun.test.service;

import com.ujun.repository.TodolistRepository;
import com.ujun.repository.TodolistRepositoryImpl;
import com.ujun.service.TodolistService;
import com.ujun.service.TodolistServiceImpl;
import com.ujun.view.TodolistView;

public class TodolistViewTest {
    public static void main(String[] args) {

        testShowTodolist();

    }

    public static void testShowTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistService.addTodolist("Belajar Java Dasar");
        todolistService.addTodolist("Belajar Java OOP");
        todolistService.addTodolist("Belajar Java Satndard classes");
        todolistService.addTodolist("Belajar Java Satndard classes");
        todolistService.addTodolist("Belajar Pyhon");
        todolistService.addTodolist("Belajar Pascal");

        todolistView.showTodolist();
    }

}
