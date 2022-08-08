package com.sunstriker.jzoffer;

public class JZ33VerifyPostOrderSequenceOfBST {
    public static void main(String[] args) {
        System.out.println(new JZ33VerifyPostOrderSequenceOfBST().VerifySquenceOfBST(new int[]{4,6,7,5}));
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return verifySequenceOfBST(sequence, 0, sequence.length-1);
    }
    public boolean verifySequenceOfBST(int[] sequence, int start, int end){
        // 无子树， 返回true
        if(start == end) return true;
        int rootNum = sequence[end];
        int rightStart = start;
        boolean isLeftBST = false, isRightBST = false;
        // 找出第一个大于根的值
        while(sequence[rightStart] < rootNum && rightStart < end){
            rightStart++;
        }
        // 无右子树，返回true
        if(rightStart == end) return true;
        // 若存在右子树，则检查子树内是否所有值都大于根
        for (int i = rightStart; i < end; i++) {
            if(sequence[i] <= rootNum) return false;
        }

        isLeftBST = rightStart - 1 <= start || verifySequenceOfBST(sequence, start, rightStart - 1);
        isRightBST = verifySequenceOfBST(sequence, rightStart, end-1);

        return isLeftBST && isRightBST;

    }
}
