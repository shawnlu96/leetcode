package com.sunstriker.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class L567字符串的排列 {
    public static void main(String[] args) {
        System.out.println(new L567字符串的排列().checkInclusion("adc", "dcdqa"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        HashMap<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            frequencies.put(s1.charAt(i), frequencies.getOrDefault(s1.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (frequencies.containsKey(c)) {
                int count = window.getOrDefault(c, 0) + 1;
                window.put(c, count);
                if (count == frequencies.get(c)) valid++;
            } else {
                left = right;
                window.clear();
                valid = 0;
            }
            if (right - left > s1.length()) {
                char d = s2.charAt(left);
                left++;
                int count = window.get(d);
                if (count == frequencies.get(d)) valid--;
                window.put(d, count - 1);

            }
            if (valid == frequencies.size()) return true;
        }
        return false;
    }
}
