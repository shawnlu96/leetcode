package com.sunstriker.leetcode;

public class L1184公交站间的距离 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        boolean flag = false;
        int dis1 = 0, dis2 = 0;
        for (int i = start; i < distance.length + start; i++) {
            int index = i % distance.length;
            if(!flag && i > destination -1) flag = true;
            if(!flag) dis1 += distance[index];
            else dis2 += distance[index];
        }
        return Math.min(dis1,dis2);
    }
}
