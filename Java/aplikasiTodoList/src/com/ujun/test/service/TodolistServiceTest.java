package com.ujun.test.service;

import com.ujun.entity.Todolist;
import com.ujun.repository.TodolistRepository;
import com.ujun.repository.TodolistRepositoryImpl;
import com.ujun.service.TodolistServiceImpl;
import com.ujun.service.TodolistService;

public class TodolistServiceTest {
    public static void main(String[] args) {
        tesRemoveTodolist();
    }

    public static void testShowTodolist() {
        TodolistRepositoryImpl todolistRepository = new TodolistRepositoryImpl();
        todolistRepository.data[0] = new Todolist("Belajar Pascal");
        todolistRepository.data[1] = new Todolist("Belajar Python");
        todolistRepository.data[2] = new Todolist("Belajar Belajar C++");
        todolistRepository.data[3] = new Todolist("Belajar Java");
        todolistRepository.data[4] = new Todolist("Belajar Javasctipt");
        todolistRepository.data[5] = new Todolist("Belajar PHP");

        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.showTodolist();

    }

    public static void testAddTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todoListService = new TodolistServiceImpl(todolistRepository);

        todoListService.addTodolist("Belajar Pascal Dasar");
        todoListService.addTodolist("Belajar Python Dasar");
        todoListService.addTodolist("Belajar Python OOP");
        todoListService.addTodolist("Belajar C++");
        todoListService.addTodolist("Belajar Java Dasar");
        todoListService.addTodolist("Belajar Javascript");
        todoListService.addTodolist("Belajar PHP");
        todoListService.addTodolist("Belajar Java OOP");

        todoListService.showTodolist();
    }

    public  static  void tesRemoveTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todoListService = new TodolistServiceImpl(todolistRepository);

        todoListService.addTodolist("Belajar Pascal Dasar");
        todoListService.addTodolist("Belajar Python Dasar");
        todoListService.addTodolist("Belajar Python OOP");
        todoListService.addTodolist("Belajar C++");
        todoListService.addTodolist("Belajar Java Dasar");
        todoListService.addTodolist("Belajar Javascript");
        todoListService.addTodolist("Belajar PHP");
        todoListService.addTodolist("Belajar Java OOP");

        todoListService.showTodolist();

        todoListService.removeTodolist(9);
        todoListService.removeTodolist(1);

        todoListService.showTodolist();

    }

}
