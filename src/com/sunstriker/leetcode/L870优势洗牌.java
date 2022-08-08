package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L870优势洗牌 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 保存nums2中的顺序和对应数字，按数字从大到小放进pq
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int left = 0, right = n - 1;
        int[] res = new int[n];
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            // 如果当前比nums1最大的还要大或者跟最大的打平，就去送人头
            if(pair[1] >= nums1[right]){
                res[pair[0]] = nums1[left++];
            }else {
                res[pair[0]] = nums1[right--];
            }
        }
        return res;
    }

}
