package com.sunstriker.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class L3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            // 不在窗口内
            while (set.contains(c)){
                char d = s.charAt(left);
                left++;
                set.remove(d);
            }
            set.add(c);
            maxLength = Math.max(maxLength, right-left);
        }
        return maxLength;
    }
}
