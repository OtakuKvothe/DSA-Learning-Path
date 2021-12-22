import java.util.Arrays;
import java.util.Scanner;

//https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
public class NumbersGivenNDigitSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String[] num = new String[n];
            for (int i = 0; i < n; i++) {
                num[i] = String.valueOf(sc.next().charAt(0));
            }
            int nu = sc.nextInt();
            System.out.println(atMostNGivenDigitSet(num, nu));
        }
    }

    public static int atMostNGivenDigitSet(String[] digits, int n) {
        int res = 0;
        int nDig=(int)Math.floor(Math.log10(n) + 1);
        for(int i=1; i<nDig; i++){
            res += (int)Math.pow(digits.length, i);
        }
        int[] pos = new int[10];
        Arrays.fill(pos, -1);
        for(int i=0; i<digits.length; i++){
            int x = Integer.parseInt(digits[i]);
            pos[x]=i;
        }
        
        return res;
    }
}
