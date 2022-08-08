package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class L735行星碰撞 {
    public static void main(String[] args) {
        var a = new L735行星碰撞().asteroidCollision(new int[]{8,-8,9,-12});
    }
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            if(asteroid > 0){
                stack.push(asteroid);
            }else{
                if(stack.isEmpty()) stack.push(asteroid);
                else{
                    // 模拟碰撞过程
                    boolean collapsed = false;
                    while (!stack.isEmpty() && stack.peek() > 0){
                        if(stack.peek() > - asteroid){
                            collapsed = true;
                            break;
                        }else{
                            if(stack.pop() == -asteroid) {
                                collapsed = true;
                                break;
                            }
                        }
                    }
                    if(!collapsed) stack.push(asteroid);
                }
            }
        }
        Collections.reverse(stack);
        return stack.stream().mapToInt(Integer::intValue).toArray();

    }
}
