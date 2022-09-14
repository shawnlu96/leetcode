package com.sunstriker.leetcode;

public class L392判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int sid = 0, tid = 0;
        while (sid < s.length() && tid < t.length()){
            if(s.charAt(sid) == t.charAt(tid++)) sid++;
        }
        return sid == s.length();
    }
}
