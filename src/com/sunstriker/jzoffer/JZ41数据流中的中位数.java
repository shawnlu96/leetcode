package com.sunstriker.jzoffer;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class JZ41数据流中的中位数 {
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

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
