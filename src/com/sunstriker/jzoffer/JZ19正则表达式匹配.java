package com.sunstriker.jzoffer;

public class JZ19正则表达式匹配 {
    public boolean match (String str, String pattern) {
        // write code here
        boolean[][] dp = new boolean[str.length()+1][pattern.length()+1];
        dp[0][0] = true;
        // 先判断正则对于空字符串的匹配
        // 第一个字符一定不匹配
        dp[0][1] = false;
        for (int i = 2; i < dp[0].length; i++) {
            char c = pattern.charAt(i-1);
            if(c == '*'){
                dp[0][i] = dp[0][i-2];
            }else{
                dp[0][i] = false;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                char a = str.charAt(i-1), b=pattern.charAt(j-1);
                if( a== b || b == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(b == '*'){
                    if(dp[i][j-2]) dp[i][j] = true;
                    else{
                        char prev = pattern.charAt(j-2);
                        if(prev == '.' || prev == a ) dp[i][j] = dp[i-1][j];
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[str.length()][pattern.length()];

    }
}
