package com.ujun;

public class Counter {
    private long value = 0L;

    public void increment() {
        this.value++;
    }

    public long getValue() {
        return this.value;
    }
}
