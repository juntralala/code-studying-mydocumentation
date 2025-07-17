package com.ujun.view;

import com.ujun.repository.TodolistRepositoryImpl;
import com.ujun.service.TodolistService;
import com.ujun.service.TodolistServiceImpl;
import com.ujun.util.InputUtil;

public class TodolistView {

    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
       this.todolistService = todolistService;
    }

    public void showTodolist() {
        while (true) {
            System.out.println("TODO");
            todolistService.showTodolist();

            System.out.println("<--- Menu --->");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");
            var input = InputUtil.input("Pilih");
            if (input.equals("1")) {
                addTodolist();
            } else if (input.equals("2")) {
                deleteTodolist();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodolist() {
        InputUtil inputUtil = new InputUtil();
        System.out.println("MENAMBAH TODO LIST");

        var todo = InputUtil.input("Todo (x jika batal)");
        if (todo.equals("x")) {
            // batal
        } else {
            todolistService.addTodolist(todo);
        }
    }

    public void deleteTodolist() {
        InputUtil inputUtil = new InputUtil();
        System.out.println("Mengahapus todo list".toUpperCase());

        String number = inputUtil.input("Nomor yang dihapus (x jika batal)");

        if (number.equals("x")) {
            // batal
        } else {
            boolean success = todolistService.removeTodolist(Integer.valueOf(number));
            System.out.println("Gagal menghapus todolist ini : " + number);
        }
    }

}
