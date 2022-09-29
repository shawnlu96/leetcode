package com.sunstriker.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L409最长回文串 {
    public int longestPalindrome(String s) {
        HashMap<Character, Boolean> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            boolean isEven = !freq.getOrDefault(s.charAt(i), true);
            freq.put(s.charAt(i), isEven);
        }
        int oddCount = 0;
        for (Map.Entry<Character, Boolean> kv : freq.entrySet()) {
            if(!kv.getValue()) oddCount++;
        }

        return oddCount <= 1 ? s.length() : s.length() - oddCount + 1;
    }
}
