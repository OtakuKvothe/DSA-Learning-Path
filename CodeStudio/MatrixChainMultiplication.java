public class MatrixChainMultiplication {
    public static int matrixMultiplication(int[] arr , int N) {
		// top down and bottom up both
        //return score(arr, 1, N-1, new int[N][N]);
        int[][] dp = new int[N][N];
        for(int i=N-1; i>0; i--) {
            dp[i][i] = 0;
            for(int j=i+1; j<N; j++) {
                int tmp = Integer.MAX_VALUE;
                for(int k=i; k<j; k++) {
                    tmp = Math.min(tmp, dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j]);
                }
                dp[i][j] = tmp;
            }
        }
        return dp[1][N-1];
	}
    
    public static int score(int[] arr, int i, int j, int[][] dp){
        if(i == j) return 0;
        else if(dp[i][j]>0) return dp[i][j];
        else {
            int res = Integer.MAX_VALUE;
            for(int k=i; k<j; k++){
                res = Math.min(res, score(arr, i, k, dp) + score(arr, k+1, j, dp) + arr[i-1]*arr[k]*arr[j]);
            }
            return dp[i][j] = res;
        }
    }
}
