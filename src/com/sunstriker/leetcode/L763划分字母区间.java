package com.sunstriker.leetcode;

import java.util.*;

public class L763划分字母区间 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    // 贪心两次遍历，只记录最后一次出现的坐标
    public static List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] map = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map[c-'a'] = Math.max(map[c-'a'], i);
        }
        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            end = Math.max(end, map[c-'a']);
            if(end == i) {
                res.add(end-start+1);
                start = end + 1;
                end = 0;
            }
        }
        return res;
    }

    // 贪心区间合并
    public static List<Integer> partitionLabelsUsingPq(String s) {
        int n = s.length();
        Integer[][] map = new Integer[26][2];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            Integer[] curr = map[c - 'a'];
            if (curr[0] == null) {
                curr[0] = i;
                curr[1] = i;
            } else {
                curr[0] = Math.min(curr[0], i);
                curr[1] = Math.max(curr[1], i);
            }
        }
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (Integer[] integers : map) {
            if (integers[0] == null) continue;
            pq.add(integers);
        }
        Integer[] range = pq.poll();
        while (!pq.isEmpty()){
            Integer[] curr = pq.poll();
            if (curr[0] > range[1]) {
                res.add(range[1] - range[0] + 1);
                range = curr;
            } else if (curr[1] > range[1]) {
                range[1] = curr[1];
            }
        }
        res.add(range[1] - range[0] + 1);

        return res;
    }
}
