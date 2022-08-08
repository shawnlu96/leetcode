package com.sunstriker.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class JZ38字符串的排列 {
    public static void main(String[] args) {
        var a = "abcd";
        System.out.println(a.substring(0, 1));
        System.out.println(a.substring(2));
        System.out.println(a.charAt(3));
        var c = a.toCharArray();
        System.out.println(String.copyValueOf(c));
        var res = new JZ38字符串的排列().Permutation("ab");
    }

    public ArrayList<String> Permutation(String str) {
        HashSet<String> res = new HashSet<>();
        rec(0, str, res);
        return new ArrayList<>(res);
    }

    public void rec(int pos, String s, HashSet<String> res) {
        if (pos == s.length() - 1) {
            res.add(s);
            return;
        }
        char[] charArr = s.toCharArray();
        for (int i = pos; i < s.length(); i++) {
            swap(charArr, i, pos);
            rec(pos+1, String.copyValueOf(charArr), res);
            swap(charArr, i, pos);
        }
    }

    public void swap(char[] charArr, int x, int y) {
        char temp = charArr[x];
        charArr[x] = charArr[y];
        charArr[y] = temp;
    }
}
