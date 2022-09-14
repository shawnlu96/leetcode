package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L49字母异位词分组 {
    public static void main(String[] args) {
        System.out.println(new L49字母异位词分组().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String code = encode(str);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(str);
        }

        return new ArrayList<>(map.values());
    }

    String encode(String str) {
        char[] freq = new char[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        return String.valueOf(freq);
    }
}
