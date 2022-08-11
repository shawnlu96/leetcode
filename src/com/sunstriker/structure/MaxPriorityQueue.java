package com.sunstriker.structure;

import java.util.ArrayList;

public class MaxPriorityQueue {
    private ArrayList<Integer> list;

    public MaxPriorityQueue() {
        list = new ArrayList<>();
    }

    public void offer(int e) {
        list.add(e);
        swim(list.size()-1);
    }

    public int poll() {
        int res = list.get(0);
        swap(0, list.size()-1);
        list.remove(list.size()-1);
        sink(0);
        return res;
    }

    private void swim(int index) {
        while (index > 0 && list.get(parent(index)) < list.get(index)) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void swap(int x, int y) {
        int temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

    private void sink(int index) {
        while (left(index) < list.size()) {
            int max = index;
            if (list.get(max) < list.get(left(index))) max = left(index);
            if (right(index) < list.size() && list.get(max) < list.get(right(index))) max = right(index);
            if(max == index) break;
            swap(index, max);
            index = max;
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public void clear() {
        list.clear();
    }
}
