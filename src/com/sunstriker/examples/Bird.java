package com.sunstriker.examples;

public class Bird implements Movable{
    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + " flied.");
    }
}
