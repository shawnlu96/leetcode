package com.sunstriker.jzoffer;

public class JZ67把字符串转换成整数 {
    public static void main(String[] args) {
        System.out.println(new JZ67把字符串转换成整数().StrToInt("2000000000000000000"));
    }
    public int StrToInt(String s) {
        // write code here
        if(s == null || s.equals("")) return 0;
        long res = 0;
        int sign = 1;
        int index = 0;
        char[] chArr = s.toCharArray();
        while (index < chArr.length && chArr[index] == ' ') index++;
        if(index >= chArr.length) return 0;
        if (chArr[index] == '+') {
            index++;
        } else if (chArr[index] == '-') {
            sign = -1;
            index++;
        }

        int maxInputIndex = (int) Math.log10(Integer.MAX_VALUE) + index + 3;
        boolean isStarted = false;
        while (index < chArr.length && index < maxInputIndex) {
            char c = chArr[index];
            if (!isStarted){
                if(c == '0') maxInputIndex++;
                else {
                    isStarted = true;
                }
            }
            if (c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                index++;
            } else {
                break;
            }
        }
        res *= sign;
        res = res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
        res = res < Integer.MIN_VALUE ? Integer.MIN_VALUE : res;
        return (int) res;
    }
}
