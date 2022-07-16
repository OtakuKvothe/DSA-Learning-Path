import java.util.Scanner;

public class MaxWtNode {
    
    public static int maxWtNode(int n, int[] arr) {
        int[] wts = new int[n];
        int max = 0;
        for(int i=0; i<n; i++) {
            wts[arr[i]] += i;
            max = Math.max(wts[arr[i]], max);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(maxWtNode(n, arr));
        }
    }
}
