package com.sunstriker.jzoffer;

public class JZ46把数字翻译成字符串 {
    /**
     * 解码
     *
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve(String nums) {
        // write code here
        if(nums.startsWith("0")) return 0;
        if (nums.length() <= 1) return nums.length();
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        int firstTwo = (nums.charAt(0)-'0') * 10 + nums.charAt(1)-'0';
        if(isMoreThanOneComb(nums.charAt(0), nums.charAt(1))){
            dp[1] = 2;
        }else {
            dp[1] = 1;
        }
        for (int i = 2; i < nums.length() ; i++) {
            if(nums.charAt(i) == '0'){
                if(nums.charAt(i-1)!='1' && nums.charAt(i-1)!= '2') return 0;
            }
            if(isMoreThanOneComb(nums.charAt(i-1) , nums.charAt(i))){
                dp[i] = dp[i-2] + dp[i-1];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[nums.length()-1];
    }
    public boolean isMoreThanOneComb(char prev, char next){
        int num = ((prev - '0') * 10 + (next - '0'));
        return (num > 10 && num < 20) || (num > 20 && num < 27);
    }
}
