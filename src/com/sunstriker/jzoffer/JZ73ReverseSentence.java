package com.sunstriker.jzoffer;

public class JZ73ReverseSentence {
    public String ReverseSentence(String str) {
        if(str == null || str.isEmpty()) return str;
        String result = "";
        String[] arr = str.split(" ");
        for(int i=arr.length-1;i>=0;i--){
            if(i>0){
                result+=arr[i]+" ";
            }else{
                result+=arr[i];
            }
        }

        return result;


    }
}
