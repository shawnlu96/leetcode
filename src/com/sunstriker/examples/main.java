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
        System.out.println(main.class.getClassLoader());
        System.out.println(main.class.getClassLoader().getParent());
        System.out.println(main.class.getClassLoader().getParent().getParent());

    }
}
