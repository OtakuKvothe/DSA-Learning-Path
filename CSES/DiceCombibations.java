//https://cses.fi/problemset/task/1633/
import java.util.Scanner;

public class DiceCombibations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0 || n == 1){
            System.out.println(n);
            sc.close();
            return;
        }
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            int top = Math.min(i, 6);
            for(int j=1; j<=top; j++){
                dp[i] += dp[i-j];
                dp[i] %= 1000000007;
            }
        }
        System.out.println(dp[n] % 1000000007);
        sc.close();
    }
}
