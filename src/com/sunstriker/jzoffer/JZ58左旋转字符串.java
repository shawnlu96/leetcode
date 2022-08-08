package com.sunstriker.jzoffer;

public class JZ58左旋转字符串 {
    public String LeftRotateString(String str, int n) {
        if (str.length() < 2) return str;
        int offset = n % str.length();
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt((i + offset - 1) % str.length());
        }
        return String.valueOf(arr);
    }
}
