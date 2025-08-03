package com.ujun;

import com.ujun.repository.TodolistRepository;
import com.ujun.repository.TodolistRepositoryImpl;
import com.ujun.service.TodolistService;
import com.ujun.service.TodolistServiceImpl;
import com.ujun.view.TodolistView;

public class MainV2 {
    public static void main(String[] args) {

        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistView.showTodolist();
    }
}
