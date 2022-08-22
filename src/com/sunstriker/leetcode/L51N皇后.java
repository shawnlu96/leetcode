package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51N皇后 {
    int test(int N) {
        // write your code in Java SE 8
        int curr = 0, max = 0;
        boolean started = false;
        while (N > 0) {
            if ((N & 1) == 1) {
                if (!started) started = true;
                else {
                    max = Math.max(curr, max);
                    curr = 0;
                }
            } else {
                if (started) curr++;
            }
            N >>= 1;
        }
        return max;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(board, n, 0, res);
        return res;
    }

    void backtrack(char[][] board, int n, int rowFinished, List<List<String>> res) {
        if (rowFinished == n) {
            res.add(Arrays.stream(board).map(String::valueOf).toList());
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(board, rowFinished, i)) continue;
            board[rowFinished][i] = 'Q';
            backtrack(board, n, rowFinished + 1, res);
            board[rowFinished][i] = '.';
        }
    }

    boolean isValid(char[][] board, int col, int row) {
        for (int i = 0; i < col; i++) {
            if (board[i][row] == 'Q') return false;
        }
        for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
            if (board[j][i] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[j][i] == 'Q') return false;
        }
        return true;
    }
}
