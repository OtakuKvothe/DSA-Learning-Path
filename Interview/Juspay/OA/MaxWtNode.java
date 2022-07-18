import java.util.Scanner;

public class MaxWtNode {
    
    public static int maxWtNode(int n, int[] arr) {
        int[] wts = new int[n];
        int max = Integer.MIN_VALUE, ind = -1;
        for(int i=0; i<n; i++) {
            if(arr[i] == -1)
                continue;
            wts[arr[i]] += i;
        }

        for(int i=0; i<n; i++) {
            if(max < wts[i]) {
                max = wts[i];
                ind = i;
            }
        }

        return ind;
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
        sc.close();
    }
}
