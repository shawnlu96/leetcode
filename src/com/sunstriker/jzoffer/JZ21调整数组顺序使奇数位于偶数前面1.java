package com.sunstriker.jzoffer;



public class JZ21调整数组顺序使奇数位于偶数前面1 {
    public static void main(String[] args) {
        reOrderArray2(new int[]{1,2,3,4});
    }
    public static int[] reOrderArray (int[] array) {
        // write code here
        int[] ans = new int[array.length];
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int oddIndex=0, evenIndex =0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==1){
                odd[oddIndex++] = array[i];
            }else {
                even[evenIndex++] = array[i];
            }
        }
        int index = 0;
        while (index < array.length){
            if(index < oddIndex){
                ans[index] = odd[index];
            }else {
                ans[index] = even[index-oddIndex];
            }
            index++;
        }
        return ans;
    }
    public static int[] reOrderArray2 (int[] array) {
        int oddIndex= 0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2 == 1){
                if(i != oddIndex){
                    int index = i;
                    while(index >= oddIndex){
                        int temp = array[index];
                        array[index] =  array[index-1];
                        array[index-1] = temp;
                        index --;
                    }
                }
                oddIndex++;
            }
        }
        return array;
    }
}
