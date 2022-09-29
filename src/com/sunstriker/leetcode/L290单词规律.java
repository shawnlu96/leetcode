package com.sunstriker.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class L290单词规律 {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        HashMap<Character, String> map  = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            if(!map.containsKey(c)){
                if(set.contains(arr[i])) return false;
                map.put(c, arr[i]);
                set.add(arr[i]);
            }else {
                if(!map.get(c).equals(arr[i])) return false;
            }
        }
        return true;
    }
}
