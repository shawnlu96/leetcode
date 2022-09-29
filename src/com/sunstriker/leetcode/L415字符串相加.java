package com.sunstriker.leetcode;

public class L415字符串相加 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i  = num1.length()-1, j = num2.length()-1, temp = 0;
        while ( i >=0 || j>=0){
            int digit1 = i>=0? (num1.charAt(i--) - '0') : 0;
            int digit2 =j>=0 ? (num2.charAt(j--) - '0'): 0;
            int res = digit1 + digit2 + temp;
            int remainder = res % 10;
            temp = res / 10;
            sb.insert(0, remainder);
        }
        if(temp != 0) sb.insert(0,1);
        return sb.toString();
    }
}
