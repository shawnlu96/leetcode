package com.sunstriker.leetcode;

public class L28StrStr {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    // Rabin-karp匹配法
    public int strStr(String haystack, String needle) {
        int length = needle.length();
        if (length > haystack.length()) return -1;
        int base = 26;
        long windowHash = 0;
        long subtrahend = 1;
        int mod = Integer.MAX_VALUE;
        for (int i = 0; i < length - 1; i++) {
            subtrahend = (subtrahend * base) % mod;
        }
        int left = 0, right = 0;
        long needleHash = 0;
        for (int i = 0; i < needle.length(); i++) {
            char c = needle.charAt(i);
            needleHash = ((needleHash * base) % mod + (c - 'a')) % mod;
        }
        while (right < haystack.length()) {
            char c = haystack.charAt(right++);
            windowHash = ((windowHash * base) % mod + (c - 'a')) % mod;

            if (right - left == length) {
                if (windowHash == needleHash) {
                    if (needle.equals(haystack.substring(left, right))) return left;
                }
                char d = haystack.charAt(left++);
                // **这里加上一个mod为了防止结果为负数**
                windowHash = (windowHash - (subtrahend * (d - 'a'))% mod + mod ) % mod;
            }
        }
        return -1;
    }
}
