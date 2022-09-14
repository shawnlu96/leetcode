package com.sunstriker.leetcode;

import java.util.HashMap;

public class L205同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        return process(s).equals(process(t));
    }

    String process(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int curr = 1;
        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), curr++);
        }
        char[] chars = new char[s.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) map.get(s.charAt(i)).intValue();
        }
        return String.valueOf(chars);
    }
}
