package com.sunstriker.jzoffer;

import java.util.Stack;

public class JZ21IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack  = new Stack<>();
        int i=0, j=0 ;
        while(j<popA.length){
            if(i<pushA.length){
                if(pushA[i] == popA[j]){
                    i++; j++;
                }else if( !stack.isEmpty() && popA[j] == stack.peek()){
                    stack.pop();
                    j++;
                }else{
                    stack.push(pushA[i++]);
                }
            } else{
                if (popA[j] == stack.pop()){
                    j++;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
