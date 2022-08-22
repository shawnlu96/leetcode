package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L787K站中转内最便宜的航班 {
    HashMap<Integer, List<Integer[]>> destinationFlights;
    int PLACEHOLDER = -544;
    int src;
    int[][] memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.src = src;
        destinationFlights = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            destinationFlights.putIfAbsent(to, new ArrayList<>());
            destinationFlights.get(to).add(new Integer[]{from, price});
        }
        memo = new int[n][k+2];
        for (int[] ints : memo) {
            Arrays.fill(ints, PLACEHOLDER);
        }
        return dp(dst, k+1);
    }

    int dp(int dst, int k){
        if(dst == this.src) return 0;
        if(k == 0) return -1;
        if(memo[dst][k] != PLACEHOLDER) return memo[dst][k];
        List<Integer[]> froms = destinationFlights.getOrDefault(dst, null);
        if(froms == null) return -1;
        int res = Integer.MAX_VALUE;
        for (Integer[] arr : froms) {
            int from = arr[0];
            int price = arr[1];
            int subProblem = dp(from, k-1);
            if(subProblem!= -1){
                res = Math.min(res, subProblem + price);
            }
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo[dst][k] = res;
        return res;
    }
}
