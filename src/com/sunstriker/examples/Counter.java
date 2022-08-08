package com.sunstriker.examples;

public class Counter {
    public volatile int count = 0;
    public void count(){

        System.out.println("current: " + ++count);
    }
}
