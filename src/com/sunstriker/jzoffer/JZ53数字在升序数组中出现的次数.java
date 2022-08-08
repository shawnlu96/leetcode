package com.sunstriker.jzoffer;

public class JZ53数字在升序数组中出现的次数 {
    public int GetNumberOfK(int [] array , int k) {
        int lIndex, rIndex;
        int l = 0, r = array.length;
        while(l<r){
            int mid = (l+r-1)/2;
            if(array[mid]<k){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        lIndex = l;
        l=0;
        r=array.length;
        while(l<r){
            int mid = (l+r-1)/2;
            if(array[mid]<=k){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        rIndex = l;
        return rIndex-lIndex;
    }
}
