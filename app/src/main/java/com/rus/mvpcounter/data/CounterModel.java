package com.rus.mvpcounter.data;

public class CounterModel {
    private int count = 0;

    public void increment() {
        ++count;
    }

    public void decrement() {
        --count;
    }

    public int getCount() {
        return count;
    }
}
