package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L592分数加减运算 {
    public static void main(String[] args) {
        System.out.println(new L592分数加减运算().fractionAddition("1/3-1/2"));
    }

    // starting 17:02
    public String fractionAddition(String expression) {
        List<int[]> fractions = new ArrayList<>();
        // 转换为分数
        int pre = 0;
        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-') {
                fractions.add(convertFractionToIntArr(expression.substring(pre, i)));
                pre = i;
            } else if (i == expression.length() - 1) fractions.add(convertFractionToIntArr(expression.substring(pre)));
        }
        // 算分母
        int lcm = fractions.get(0)[1];
        for (int i = 1; i < fractions.size(); i++) {
            lcm = lcm(lcm, fractions.get(i)[1]);
        }
        // 算分子
        int dividend = 0;
        for (int[] fraction : fractions) {
            dividend += fraction[0] * lcm / fraction[1];
        }
        // 约分
        int gcd = gcd(lcm, dividend);
        lcm /= gcd;
        dividend /= gcd;
        return dividend + "/" + lcm;
    }

    private int[] convertFractionToIntArr(String fraction) {
        int[] ele = new int[2];
        String[] split = fraction.split("/");
        ele[0] = Integer.parseInt(split[0]);
        ele[1] = Integer.parseInt(split[1]);
        return ele;
    }

    // 最大公约数
    private int gcd(int a, int b) {
        int upper = Math.max(Math.abs(a),Math.abs(b));
        int lower = Math.min(Math.abs(a),Math.abs(b));
        if(lower == 0) return upper;
        int remainder = upper % lower;
        while (remainder != 0) {
            upper = lower;
            lower = remainder;
            remainder = upper % lower;
        }
        return lower;
    }

    // 最小公倍数
    private int lcm(int a, int b) {
        if (a == b) return a;
        return (a * b) / gcd(a, b);
    }
}
