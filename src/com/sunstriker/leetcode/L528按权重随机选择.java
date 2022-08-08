package com.sunstriker.leetcode;

import java.util.Random;

public class L528按权重随机选择 {
    class Solution {
        int[] preSum;
        Random r;

        public Solution(int[] w) {
            preSum = new int[w.length];
            preSum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                preSum[i] = preSum[i - 1] + w[i];
            }
            r = new Random();
        }

        public int pickIndex() {
            if (preSum.length == 1) return 0;
            int target = r.nextInt(0, preSum[preSum.length - 1]);
            int left = 0, right = preSum.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (preSum[mid] > target) {
                    right = mid - 1;
                } else if (preSum[mid] < target) {
                    left = mid + 1;
                }else {
                    left = mid + 1;
                }
            }
            return left;

        }


    }

}
