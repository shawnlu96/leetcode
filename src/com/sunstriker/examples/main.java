package com.sunstriker.examples;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    private static Unsafe reflectGetUnsafe() {

        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
    public static void main(String[] args) {
        var counter = new Counter();
        Thread t = new Thread(()->{
            try {
                Thread.sleep(3000);
                counter.count();
                System.out.println("count changed");
                Thread.sleep(3000);
                System.out.println("end of sub-thread");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
        while (true){
            if(counter.count!=0){
                System.out.println("count change detected, break!");
                break;
            }
        }
        System.out.println("end of main");

    }
}
