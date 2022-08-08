package com.sunstriker.jzoffer;

public class JZ12矩阵中的路径 {
    public boolean hasPath(char[][] matrix, String word) {
        // write code here
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(dfs(matrix,word,i,j,0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] matrix, String word, int i, int j, int index) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != word.charAt(index))
            return false;
        if (index == word.length() - 1) return true;
        char tmp = matrix[i][j];
        matrix[i][j] = '*';
        boolean res = dfs(matrix, word, i + 1, j, index + 1)
                || dfs(matrix, word, i - 1, j, index + 1)
                || dfs(matrix, word, i, j + 1, index + 1)
                || dfs(matrix, word, i, j - 1, index + 1);
        matrix[i][j] = tmp;
        return res;
    }
}
