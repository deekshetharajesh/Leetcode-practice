class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) return new int[0];
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, k = 1;
        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];

            if (k == 1) { 
                if (col == n - 1) {
                    row++;
                    k = -1;
                } else if (row == 0) {
                    col++;
                    k = -1;
                } else {
                    row--;
                    col++;
                }
            } else { // Moving down
                if (row == m - 1) {
                    col++;
                  k = 1;
                } else if (col == 0) {
                    row++;
                    k = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}
