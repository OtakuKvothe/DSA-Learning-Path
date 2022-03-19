//https://leetcode.com/problems/student-attendance-record-ii/
public class StudentAttendanceRecord2 {
    public int checkRecord(int n) {
        int MOD = 1000000007;
        int[][][] dp = new int[n+1][3][2];
        dp[0] = new int[][]{{1, 1}, {1, 1}, {1, 1}};
        for(int i=1; i<=n; i++){
            for(int j=0; j<3; j++){   
                for(int k=0; k<2; k++){
                    long val = dp[i-1][2][k]; //P
                    if(j>0) val = (val + dp[i-1][j-1][k])%MOD; //L
                    if(k>0) val = (val + dp[i-1][2][k-1])%MOD; //A
                    dp[i][j][k]=(int)val;
                }
            }
        }
        return dp[n][2][1];
    }
}

//Try the O(log n) approach