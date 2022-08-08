package com.sunstriker.jzoffer;

public class JZ3数组中重复的数字 {
    public int duplicate (int[] numbers) {
        // write code here
        int i = 0;
        while (i<numbers.length){
            if(numbers[i]==i){
                i++;
                continue;
            }
            if(numbers[i] == numbers[numbers[i]]) return numbers[i];
            else{
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return -1;
    }
}
