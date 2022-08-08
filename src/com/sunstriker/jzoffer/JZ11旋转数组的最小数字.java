package com.sunstriker.jzoffer;

public class JZ11旋转数组的最小数字 {
    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{2,2,1,2,2}));
    }
     public static int minNumberInRotateArray(int [] array) {
        int l=0,  r =  array.length;
        if(array.length ==0 )return 0;
        if(array.length ==1 )return array[0];
        if(array.length ==2 )return array[1];
        while (l<r){
            int mid = (l+r-1) /2;

            if(array[mid]< array[r]) {
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return array[l];
    }
}
