package com.sunstriker.jzoffer;

public class JZ83剪绳子2 {
    final int MOD = 998244353;

    public static void main(String[] args) {
        System.out.println("abcd".substring(1));
    }

    public long cutRope(long number) {
        // write code here
        if (number == 2) return 1;
        if (number == 3) return 2;
        int remainder = (int) (number % 3);
        long times =  (number / 3);
        if (remainder == 1) return (pow3(times - 1) * 4) % MOD;
        else if (remainder == 2) return (pow3(times - 1) * 6) % MOD;
        else return pow3(times);
    }

    public long pow3(long n) {
        if(n == 0) return 1;
        if(n == 1) return 3;
        long base = 3;
        long multiplier = 1;
        while (n > 1) {
            if (n % 2 == 1) {
                multiplier = (base * multiplier) % MOD;
            }
            base = (base * base) % MOD;
            n /= 2;
        }
        return (base * multiplier) % MOD;
    }
}
