package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L1260二维网格迁移 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int cap =  grid.length * grid[0].length;
        int step = k % cap;
        List<List<Integer>> res = new ArrayList<>(grid.length);
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < cap; i++) {
            int pos = (i - step + cap)  % cap;
            int m = pos / grid[0].length;
            int n = pos % grid[0].length;
            row.add(grid[m][n]);
            if((i+1) % grid[0].length == 0){
                res.add(row);
                row = new ArrayList<>();
            }
        }
        return res;
    }
}
