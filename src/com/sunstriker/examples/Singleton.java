package com.sunstriker.examples;

public enum Singleton {
    INSTANCE;
    public int count = 0;
    public void test(){
        System.out.println("hello: " + ++count);
    }
}
