package com.sunstriker.leetcode;

public class L1049最后一块石头的重量II {
    public int lastStoneWeightII(int[] stones) {
        if(stones.length == 1) return stones[0];
        if(stones.length == 2) return Math.abs(stones[1]- stones[0]);
        int sum = 0, max = 0, largestSum;
        for (int stone : stones) {
            sum+=stone;
            max = Math.max(stone, max);
        }
        int remainder = sum % 2;
        if(max >= sum/2) largestSum = max;
        else{
            largestSum = largestSum(stones, sum/2);
        }
        return Math.abs(sum/2 - largestSum) * 2 + remainder;
    }

    int largestSum(int[] stones, int target){
        int n = stones.length;
        int[] dp = new int[target+1];
        for (int i = 1; i <=n ; i++) {
            int lastWeight = stones[i-1];
            for (int j = target; j >= lastWeight; j--) {
                dp[j] = Math.max(dp[j], dp[j-lastWeight] + lastWeight);
            }
        }
        return dp[target];
    }
}
