package com.sunstriker.jzoffer;

public class JZ20表示数值的字符串 {
    public static void main(String[] args) {
        System.out.println(isNumeric("1e "));
    }
    public static boolean isNumeric (String str) {
        // write code here
        if(str == null || str.length()==0) return false;
        int index = 0;
        char[] chArr = str.toCharArray();
        while ( index < chArr.length && chArr[index] == ' ') index++;
        if(index == chArr.length) return false;
        int startIndex = index;
        boolean hasE = false, hasDot = false, isEnd = false ,hasNumber = false;
        while (index < chArr.length){
            char c = chArr[index];
            if(c == '.') {
                // 小数点只能出现一次且只能在e前
                if(hasDot || hasE) return false;
                hasDot = true;
                if(startIndex == index|| chArr[index-1]=='-'||chArr[index-1]=='+') {
                    // 若数字以小数点开头，则小数点后必须跟数字
                    if(index == chArr.length-1 || chArr[index+1] <'0' || chArr[index+1]>'9')return false;
                }
            }else if(c == 'E' || c == 'e'){
                // 不能出现2次e,e前必须有数字，e不能作为最后一位
                if(hasE || !hasNumber||index == chArr.length-1 || chArr[index+1] == ' ') return false;
                hasE = true;

            }else if(c== '+' || c == '-'){
                // 正负号只能出现在首位或者e后一位
                if(index != startIndex && (chArr[index-1]!='e' && chArr[index-1]!= 'E')){
                    return false;
                }
                // 不能出现在最后一位
                if(index == chArr.length-1 || chArr[index+1] == ' ') return false;
            }else if(c >='0' && c<='9'){
                if(!hasNumber) hasNumber = true;
            }else if(c == ' '){
                isEnd = true;
                break;
            }else{
                return false;
            }
            index++;
        }
        // 判断空格后是否还有字符
        if(isEnd){
            while (index< chArr.length){
                if(chArr[index++] != ' ') return false;
            }
        }
        return true;
    }
}
