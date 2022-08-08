package com.sunstriker.examples;

public abstract class Mammal implements Movable{
    public int age;
    public Mammal(int age){
        this.age = age;
    }
    public abstract void pregnant();

//    @Override
//    public int hashCode() {
//        return age;
//    }
}
