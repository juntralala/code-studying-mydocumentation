package com.ujun.repository;

import com.ujun.entity.Todolist;

public class TodolistRepositoryImpl implements TodolistRepository {

    public Todolist[] data = new Todolist[10];

    public boolean isFull() {
        // cek apakah model penuh
        var isFull = true;
        for (var i = 0; i< data.length ; i++) {
            // model masih ada yang kosong
            if (data[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull() {
        // jika penuh, kita resize ukuran array 2X lipat
        if (isFull()) {
            var temp = data;
            data = new Todolist[data.length * 2];

            for (var i = 0; i<temp.length ; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public Todolist[] getAll() {
        return data;
    }

    @Override
    public void add(Todolist todolist) {
        resizeIfFull();

        // tambahkan keposisi data yang array nya null
        for (var i = 0; i<data.length ; i++) {
            if (data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        /**
         * menghapus todo dari list
         */
        if (((number - 1) >= data.length) || (data[number - 1] == null)) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
