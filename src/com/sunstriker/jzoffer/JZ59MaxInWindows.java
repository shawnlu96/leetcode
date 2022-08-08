package com.sunstriker.jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class JZ59MaxInWindows {
    public static void main(String[] args) {
        System.out.println(new JZ59MaxInWindows().maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3));
    }
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0 || size > num.length) return res;
        // queue内存储窗口内的递减序列的compound
        LinkedList<Integer> queue = new LinkedList<>();
        int windowFirstIndex = 0;
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] > (queue.getLast()<<16)>>16) {
                queue.removeLast();
            }
            queue.addLast((i<<16) | num[i]);
            // 如果queue内最左侧已经在窗口外，移除最左侧元素
            if(i-(queue.getFirst()>>16 )>=size) queue.removeFirst();
            if(i>=size-1) res.add((queue.getFirst()<<16)>>16 );
        }
        return res;
    }

    public static int comp(int num, int index) {
        return (index << 16) | num;
    }

    public static int getIndex(int comp) {
        return comp >> 16;
    }

    public static int getNum(int comp) {
        return (comp << 16) >> 16;
    }
}
