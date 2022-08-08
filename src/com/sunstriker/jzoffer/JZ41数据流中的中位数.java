package com.sunstriker.jzoffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JZ41数据流中的中位数 {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void Insert(Integer num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double GetMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
    }
}
