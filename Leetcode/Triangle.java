//https://leetcode.com/problems/triangle

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] minSum = new int[n][n];
        minSum[0][0] = triangle.get(0).get(0);
        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                minSum[i][j] = triangle.get(i).get(j);
                
                if(j>0 && i != j) {
                    minSum[i][j] += Math.min(minSum[i-1][j], minSum[i-1][j-1]);
                } else if(j == i) {
                    minSum[i][j] += minSum[i-1][j-1];
                } else {
                    minSum[i][j] += minSum[i-1][j];
                }
                //System.out.print(minSum[i][j] + "\t");
            }
            //System.out.println();
        }
        int res = (int) 1e9;
        for(int i=0; i<n; i++) {
            //System.out.print(minSum[n-1][i]+" ");
            res = Math.min(res, minSum[n-1][i]);
        }
        System.out.println();
        return res;
    }
}
