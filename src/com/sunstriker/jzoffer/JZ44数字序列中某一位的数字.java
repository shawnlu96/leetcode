package com.sunstriker.jzoffer;

public class JZ44数字序列中某一位的数字 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(19200));
        System.out.println(findNthDigit1(19200));
    }
    public int Sum_Solution(int n) {
        boolean flag = (n > 1) && ((n += Sum_Solution(n - 1)) < 0);
        return n;
    }
    public static int findNthDigit (int n) {
        // write code here
        if(n<10) return n;
        long startingIndex = 1;
        int digitCount = 1;
        long nextIndex = 10;
        while (nextIndex<n) {
            startingIndex = nextIndex;
            digitCount++;
            nextIndex += 9 * Math.pow(10, digitCount-1) * digitCount;
        }
        long leftover = n - startingIndex;
        long actualNumber = leftover / digitCount + (long) Math.pow(10, digitCount-1);
        int indexOfNumber = (int)(leftover % digitCount);
        return String.valueOf(actualNumber).charAt(indexOfNumber)-'0';
    }

    public static int findNthDigit1 (int n) {
        // 找规律，分三步

        // step1：定位n落到“几位数”区间
        int len=1;// 几位数
        long start=1; // 当前x位数区间的起始数字，1,10,100...
        long preSum=9; // 当前区间之前有多少位

        // while结束后，n会定位在某个x位数区间
        while(n>preSum){
            n -= preSum;
            len += 1; // 数字位长每次+1
            start *= 10; // 起始位每次*10
            preSum = 9 * start * len; // 更新一下当前区间的位数: 个位数有9个，两位数90*2个，三位数900*3个...
        }
        // step2：定位n落到具体哪一个数字上
        long number = start + (n-1)/len;
        // step3：定位n落在这个数字第几位上，返回这位数即可
        int position = (n-1)%len;

        return (number + "").charAt(position)-'0';
    }

}
