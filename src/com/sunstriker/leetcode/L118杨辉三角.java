package com.sunstriker.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class L118杨辉三角 {

    public List<List<Integer>> generate(int numRows) {
        var map = new HashMap<Integer, String>();
        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            Integer[] currRow = new Integer[i + 1];
            currRow[0] = 1;
            currRow[currRow.length - 1] = 1;
            for (int j = 1; j < currRow.length - 1; j++) {
                List<Integer> lastRow = res.get(i - 1);
                currRow[j] = lastRow.get(j - 1) + lastRow.get(j);
            }
            res.add(List.of(currRow));
        }
        return res;
    }
}
