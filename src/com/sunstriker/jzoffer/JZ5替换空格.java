package com.sunstriker.jzoffer;

public class JZ5替换空格 {
    public String replaceSpace (String s) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            if(c!=' ') sb.append(c);
            else sb.append("%20");
        }
        return sb.toString();
    }
}
