package com.sunstriker.leetcode;

public class L1109航班预订统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+1];
        for (int[] booking : bookings) {
            diff[booking[0]-1] += booking[2];
            diff[booking[1]] -= booking[2];
        }
        int[] res= new int[n];
        for (int i = 0; i < res.length; i++) {
            if(i==0) res[i] = diff[i];
            else res[i] = res[i-1] + diff[i];
        }
        return res;
    }
}
