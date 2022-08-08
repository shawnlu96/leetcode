package com.sunstriker.jzoffer;

import java.util.HashMap;

public class JZ48最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        System.out.println(new JZ48最长不含重复字符的子字符串().lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        // write code here
        if(s.length() == 0 || s.length() == 1) return s.length();
        int maxLength = 0;
        // 滑动窗口的开始位置
        // 字母出现的最后位置
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        // dp[i]是以第i字母结尾的最长子字符串长度
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
                dp[i] = dp[i-1] + 1;
            }else{
                if(i - map.get(c) > dp[i-1]) dp[i] = dp[i-1] + 1;
                else dp[i]= i - map.get(c);
                map.put(c, i);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;

    }
}
