package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L438找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()){
            char c = s.charAt(right++);
            if(need.containsKey(c)){
                int currentCount = window.getOrDefault(c, 0) + 1;
                window.put(c, currentCount);
                if(currentCount == need.get(c)) valid++;
            }else{
                window.clear();
                valid = 0;
                left = right;
            }
            if(right - left > p.length()){
                char d = s.charAt(left++);
                int count = window.get(d);
                if(count == need.get(d)) valid--;
                window.put(d, count-1);
            }
            if(valid == need.size()) res.add(left);
        }
        return res;
    }
}
