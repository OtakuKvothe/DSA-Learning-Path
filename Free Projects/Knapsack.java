import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n];
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
                w[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            System.out.println(compute(k, w, p, n));
        }
        sc.close();
    }

    public static int compute(int k, int[] w, int[] p, int n) {

        if (n == 0 || k == 0) {
            return 0;
        }

        if (w[n - 1] > k) {
            return compute(k, w, p, n - 1);
        }

        return Math.max(p[n - 1] + compute(k - w[n - 1], w, p, n - 1), compute(k, w, p, n - 1));
    }
}
