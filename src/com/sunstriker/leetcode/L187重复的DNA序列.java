package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L187重复的DNA序列 {
    public static void main(String[] args) {
        new L187重复的DNA序列().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
    public List<String> findRepeatedDnaSequences(String s) {
        int left = 0, right = 0;
        HashSet<String> res = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        int number = 0;
        while (right < s.length()){
            char c = s.charAt(right++);
            int digit = convert(c);
            number <<= 2;
            number += digit;
            if(right - left > 10){
                char d = s.charAt(left++);
                int deleteDigit = convert(d);
                number -=( deleteDigit<<20);
            }
            if(right-left == 10){
                if(set.contains(number)) res.add(s.substring(left, right));
                else set.add(number);
            }
        }
        return new ArrayList<>(res);
    }

    public int convert (char c){
        return switch (c) {
            case 'A' -> 0;
            case 'C' -> 1;
            case 'G' -> 2;
            case 'T' -> 3;
            default -> -1;
        };
    }
}
