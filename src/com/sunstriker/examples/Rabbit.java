package com.sunstriker.examples;

public class Rabbit extends Mammal{

    String name;
    public Rabbit(String name, int age) {
        super(age);
        this.name  = name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Rabbit a  && a.age == age
                && a.name.equals(name)
                ;
    }

    @Override
    public void pregnant() {

    }
}
