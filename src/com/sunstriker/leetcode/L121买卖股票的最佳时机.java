package com.sunstriker.leetcode;

public class L121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int last = 0, minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            last = Math.max(last, Math.max(0, prices[i] - minPrice));
        }
        return last;
    }

    public int maxProfit2(int[] prices) {
//        int profit = 0;
//        for (int i = 1; i < prices.length ; i++) {
//            int change = prices[i] - prices[i-1];
//            profit+=Math.max(0, change);
//        }
//        return profit;
        int n = prices.length;
        int lastHolding = -prices[0], lastEmpty = 0;
        for (int i = 1; i < n; i++) {
            // 不持有股票
            int empty = Math.max(lastEmpty, lastHolding + prices[i]);
            // 持有
            int holding = Math.max(lastEmpty - prices[i], lastHolding);
            lastEmpty = empty;
            lastHolding = holding;
        }
        return lastEmpty;
    }

    public int maxProfitWithCoolDown(int[] prices) {
        int n = prices.length;
        // 0空仓，1持有
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 不持有股票,卖出或继续空仓
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            // 持有,买入或不动
            dp[i][1] = Math.max((i > 1 ? dp[i - 2][0] : 0) - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    public int maxProfitWithFee(int[] prices, int fee) {
        // 0空仓，1持有
        int lastHolding = -prices[0], lastEmpty = 0;
        for (int i = 1; i < prices.length; i++) {
            // 不持有股票,卖出或继续空仓
            int temp = Math.max(lastHolding + prices[i] - fee, lastEmpty);
            // 持有,买入或不动
            lastHolding = Math.max(lastEmpty - prices[i], lastHolding);
            lastEmpty = temp;
        }
        return lastEmpty;
    }

    public int maxProfitWithKTime(int k, int[] prices) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        // 0空仓，1持有
        int[][] dp = new int[k + 1][2];

        for (int i = 1; i <= k; i++) {
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                // 不持有股票,卖出或继续空仓
                dp[j][0] = Math.max(dp[j][1] + prices[i], dp[j][0]);
                // 持有,买入或不动
                dp[j][1] = Math.max(dp[j - 1][0] - prices[i], dp[j][1]);

            }
        }
        return dp[k][0];
    }
}
