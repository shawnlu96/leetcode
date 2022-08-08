package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class L710黑名单中的随机数 {
    public static void main(String[] args) {
        var s = new L710黑名单中的随机数().new Solution(4, new int[]{2,3});
        s.pick();
    }
    class Solution {
        Random r = new Random();
        HashMap<Integer, Integer> map;
        int startIndex, endIndex;
        public Solution(int n, int[] blacklist) {
            map = new HashMap<>();
            for (int black : blacklist) {
                map.put(black, -1);
            }
            int left = 0;
            startIndex = blacklist.length;
            for (int black : blacklist) {
                if(black < startIndex) continue;
                while (map.containsKey(left)) left++;
                map.put(black, left++);

            }
            endIndex = n;
        }

        public int pick() {
            int num = r.nextInt(startIndex, endIndex);
            if (map.containsKey(num)){
                num = map.get(num);
            }
            return num;
        }
    }
}
