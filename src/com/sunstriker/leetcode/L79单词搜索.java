package com.sunstriker.leetcode;

public class L79单词搜索 {
    public static void main(String[] args) {
        System.out.println(new L79单词搜索().exist(new char[][]{{'A'}}, "A"));
    }

    int m, n;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        char[] chArr = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != chArr[0]) continue;
                if (backtrack(board, j, i, chArr, 0)) return true;
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, int startX, int startY, char[] word, int start) {
        if (visited[startY][startX]) return false;
        if (board[startY][startX] != word[start]) return false;
        if (start + 1 == word.length) return true;
        visited[startY][startX] = true;
        for (int[] direction : directions) {
            int newX = startX + direction[0], newY = startY + direction[1];
            if (newX >= n || newX < 0 || newY >= m || newY < 0) continue;
            if (backtrack(board, newX, newY, word, start + 1)) return true;
        }
        visited[startY][startX] = false;
        return false;
    }
}
