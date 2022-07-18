import java.util.Scanner;

public class Doremy {

    public static String solve(int[] arr, int n, int q) {
        
        return "";
    }

    public static String helper(int[] arr, int i, int q, int num, String res) {

        if(i == arr.length) {
            return res;
        }

        if(arr[i] <= q) {
            return helper(arr, i+1, q, num+1, res+"1");
        } else {
            //return Math
        }

        return "";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println();
        }
        sc.close();
    }
}
