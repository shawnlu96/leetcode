package com.sunstriker.jzoffer;

public class JZ4二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        int m=array.length-1,n=0;
        while (m>=0 && n < array[0].length){
            if(target == array[m][n]) return true;
            if(target > array[m][n]) n++;
            if(target < array[m][n]) m--;
        }
        return false;
    }
}
