package com.sunstriker.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class L341扁平化嵌套列表迭代器 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    class NestedIterator implements Iterator<Integer> {

        LinkedList<NestedInteger> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.list = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return list.remove(0).getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!list.isEmpty() && !list.get(0).isInteger()){
                List<NestedInteger> res = list.remove(0).getList();
                for (int i = res.size() - 1; i >= 0; i--) {
                    list.addFirst(res.get(i));
                }
            }
            return !list.isEmpty();
        }
    }
}
