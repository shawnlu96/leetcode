package com.sunstriker.jzoffer;

public class TEEEST {
    public static void main(String[] args) {
        System.out.println(new TEEEST().convert(" -"));
    }

    public int convert(String num) {
        long res = 0;
        int sign = 1;
        int index = 0;

        while (num.charAt(index) == ' '){
            index ++;
        }
        if (num.charAt(index) == '+') {
            sign = 1;
            index ++;
        }
        if (num.charAt(index) == '-') {
            sign = -1;
            index ++;
        }

        while (index < num.length()) {
            if (num.charAt(index) <= '9' && num.charAt(index) >= '0') {
                res = res * 10 + num.charAt(index) - '0';
                index++;
            } else {
                break;
            }

        }
        res = sign * res;

        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) res;
    }
}
