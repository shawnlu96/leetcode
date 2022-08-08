package com.sunstriker.leetcode;

public class L5最长回文子串 {
    public static void main(String[] args) {
        System.out.println(new L5最长回文子串().longestPalindrome("cbbd"));
    }
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String res = "";
        for (int i = 0; i < s.length()-1; i++) {
            String s1 = findPalindrome(s, i,i);
            String s2 = findPalindrome(s, i,i+1);
            if(s1.length() > res.length()) res = s1;
            if(s2.length() > res.length()) res = s2;
        }
        return res;
    }

    private String findPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
