//https://leetcode.com/problems/maximal-rectangle

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0;
        int[][] wt = new int[m][n];
        for(int i=0; i<m; i++) {            
            for(int j=0; j<n; j++) {
                if(i==0) {
                    wt[i][j] = mat[i][j] - '0';
                } else {
                    if(mat[i][j] == '0') {
                        wt[i][j] = 0;
                    } else {
                        wt[i][j] = wt[i-1][j] + 1;
                    }
                }
            }
            Stack<Integer> st = new Stack<>();
            int tmp = 0;
            for(int j=0; j<=n; j++) {
                while(!st.isEmpty() && ((j==wt[i].length) || (wt[i][j]<wt[i][st.peek()]))) {
                    int prev = st.pop();
                    if(st.isEmpty()) {
                        tmp = Math.max(tmp, wt[i][prev] * j);
                    } else {
                        tmp = Math.max(tmp, wt[i][prev] * (j - st.peek() - 1));
                    }
                }
                st.push(j);
            }
            res = Math.max(tmp, res);
        }
        return res;
    }
}
