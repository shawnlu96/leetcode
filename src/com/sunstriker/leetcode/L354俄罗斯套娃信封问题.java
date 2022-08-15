package com.sunstriker.leetcode;

import java.util.Arrays;

public class L354俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a ,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] heights = Arrays.stream(envelopes).mapToInt(e ->e[1]).toArray();
        return lengthOfLIS(heights);
    }

    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        //***** 搜索左侧边界的二分查找 *****
        //*********************************
        for (int poker : nums) {
            // 要处理的扑克牌
            // 搜索左侧边界的二分查找**************
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            //*********************************

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}
