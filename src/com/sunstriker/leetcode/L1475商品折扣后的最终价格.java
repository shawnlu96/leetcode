package com.sunstriker.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class L1475商品折扣后的最终价格 {
    public int[] finalPrices(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(prices.length);
        for (int i = prices.length - 1; i >= 0; i--) {
            int discount = 0;
            while (!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) discount = stack.peek();
            stack.push(prices[i]);
            prices[i] -= discount;
        }
        return prices;
    }

    public int[] finalPrices1(int[] prices){
        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i+1; j < prices.length ; j++) {
                if(prices[j]<=prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            prices[i] = prices[i] - discount;
        }
        return prices;
    }

}
