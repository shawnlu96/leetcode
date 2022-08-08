package com.sunstriker.jzoffer;

public class JZ61扑克牌顺子 {
    public static void main(String[] args) {
        var a = new int[]{1, 0, 0, 0, 6};
        System.out.println(new JZ61扑克牌顺子().IsContinuous(a));
    }

    public boolean IsContinuous(int[] numbers) {
        int max = -1, min = 15, zeroCount = 0;
        for (int i = 0; i < numbers.length - zeroCount; i++) {
            int n = numbers[i];
            if (n == 0) {
                swap(numbers, i--, numbers.length - 1 - zeroCount++);
            } else {
                if (n < min) min = n;
                if (n > max) max = n;
            }
        }
        if (zeroCount > 3) return true;
        if (max - min > 4) return false;
        int flag = 0;
        for (int i = 0; i < numbers.length - zeroCount; i++) {
            int n = numbers[i];
            if((flag&(1<<n))==0){
                flag|=(1<<n);
            }else {
                return false;
            }
        }
        return true;

    }

    public void swap(int[] numbers, int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }
}
