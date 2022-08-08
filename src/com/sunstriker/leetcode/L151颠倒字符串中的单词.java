package com.sunstriker.leetcode;

public class L151颠倒字符串中的单词 {
    public static void main(String[] args) {
        System.out.println(new L151颠倒字符串中的单词().reverseWords("the   sky    is     blue"));
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = (arr.length) - 1;
        reverse(arr, l, r);
        for (int i = 0; i < arr.length; i++) {
            int wordLength = 0;
            boolean wordStarted = false;
            for (int j = i; j < arr.length; j++) {
                if (!wordStarted) {
                    if (arr[j] != ' ') {
                        wordStarted = true;
                    }
                }
                if (wordStarted){
                    wordLength++;
                    if (j + 1 == arr.length || arr[j + 1] == ' ') {
                        reverse(arr, i, j);
                        i += wordLength;
                        break;
                    }
                }
            }
            if(!wordStarted) break;
        }
        return String.valueOf(arr).trim();

    }

    public void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
