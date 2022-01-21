//https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums
public class ValidMatrix {
    public int[][] restoreMatrix(int[] row, int[] col) {
        int[][] res = new int[row.length][col.length];
        for(int i=0; i<row.length; i++){
            for(int j=0; j<col.length; j++){
                int x = Math.min(row[i], col[j]);
                res[i][j]=x;
                row[i]-=x;
                col[j]-=x;
            }
        }
        return res;
    }
}
