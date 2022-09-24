package com.sunstriker.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class L313超级丑数 {
    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

    // 超时了
    public static int nthSuperUglyNumberWithPQOnly(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> used = new HashSet<>();
        pq.offer(1l);
        for (int i = 1; i < n; i++) {
            long num = pq.poll();
            for (int prime : primes) {
                long curr = num * prime;
                if (used.contains(curr)) continue;
                pq.offer(curr);
                used.add(curr);
            }
        }
        return Math.toIntExact(pq.peek());
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int length = primes.length;
        long[] res = new long[n];
        int[] indices = new int[length];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Long.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                res[i] = Math.min(res[i], primes[j] * res[indices[j]]);
            }

            for (int j = 0; j < length; j++) {
                if (res[i] == res[indices[j]] * primes[j]) {

                    indices[j]++;
                }
            }
        }
        return (int) res[n - 1];
    }
}
