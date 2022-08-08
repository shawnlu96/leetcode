package com.sunstriker.leetcode;

import java.util.ArrayList;

public class L799香槟塔 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        ArrayList<double[]> res = new ArrayList<>();
        res.add(new double[]{poured});
        boolean hasNext = true;
        for (int i = 1; i <= query_row && hasNext; i++) {
            hasNext = false;
            double[] row = new double[i + 1];
            for (int j = 0; j <= i; j++) {
                double upRight = j == i ? 0 : Math.max(0, (res.get(i - 1)[j] - 1) / 2);
                double upLeft = j == 0 ? 0 : Math.max(0, (res.get(i - 1)[j - 1] - 1) / 2);
                row[j] = upLeft + upRight;
                if (!hasNext && row[j] > 1) hasNext = true;
            }
            res.add(row);
        }
        return query_row < res.size() ? Math.min(1, res.get(query_row)[query_glass] ) : 0;
    }
}
