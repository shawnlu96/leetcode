package com.sunstriker.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L2399检查相同字母间的距离 {
    public static boolean checkDistances(String s, int[] distance) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(distance[c-'a'] >= 0) distance[c-'a'] = -distance[c-'a'] -i - 1;
            else {
                if((distance[c-'a'] += i) != 0) return false;
            }
        }

        return true;
    }
}
