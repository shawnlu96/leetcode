package com.sunstriker.leetcode;

import java.util.HashMap;

public class L76最小覆盖子串 {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character, Integer> window = new HashMap<>(), targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, validCount = 0, targetCount = targetMap.size();
        String res = "";
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if(targetMap.containsKey(c)){
                int currentTimes = window.getOrDefault(c, 0) + 1;
                window.put(c, currentTimes);
                if(currentTimes == targetMap.get(c)) validCount ++;
            }

            while (validCount == targetCount){
                if(res.equals("") || right  - left < res.length()) res = s.substring(left, right);
                char d = s.charAt(left);
                left++;
                if(targetMap.containsKey(d)){
                    int currentTimes = window.getOrDefault(d, 0) - 1;
                    window.put(d, currentTimes);
                    if(currentTimes < targetMap.get(d)) validCount --;
                }
            }
        }
        return res;
    }
}
