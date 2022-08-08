package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class JZ7ReConstructBinaryTree {
    public static void main(String[] args) {
        var arr = new int[] {1,2,3,4,5};
        ArrStr(Arrays.copyOfRange(arr, 0 ,2));
    }

    public static void ArrStr (int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre == null || pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if(pre.length == 1 )return root;
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if(in[i]==pre[0]) {
                index = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(
                Arrays.copyOfRange(pre, 1, 1+index),
                Arrays.copyOfRange(in, 0, index));

        root.right = reConstructBinaryTree(
                Arrays.copyOfRange(pre, 1+index, pre.length),
                Arrays.copyOfRange(in, 1+index, in.length)
        );
        return root;
    }
}
