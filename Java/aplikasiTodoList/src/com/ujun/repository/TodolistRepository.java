package com.ujun.repository;

import com.ujun.entity.Todolist;

public interface TodolistRepository {

    Todolist[] getAll();

    void add(Todolist todolist);

    boolean remove(Integer number);

}
