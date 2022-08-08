package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class L380O1时间插入删除和获取随机元素 {
    public static void main(String[] args) {
        var r = new L380O1时间插入删除和获取随机元素().new RandomizedSet();
        r.remove(0);
        r.remove(0);
        r.insert(0);
        System.out.println(r.getRandom());
        r.remove(0);
        r.insert(0);

    }
    class RandomizedSet {
        List<Integer> list;
        HashMap<Integer, Integer> map;
        Random random;
        int front = 0, rear = 0;
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            list.add(rear, val);
            map.put(val, rear++);
            var a = getList();
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            int index = map.get(val);
            int frontVal = list.get(front++);
            list.set(index,frontVal);
            map.put(frontVal, index);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(front, rear));
        }

        public List<Integer> getList(){
            return list.subList(front, rear);
        }
    }

}
