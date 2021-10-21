import java.util.Scanner;

public class DIGITREM {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                String N = sc.next();
                int n = Integer.parseInt(N);
                int d = sc.nextInt();
                int l = N.length();
                int s = 0;
                double x = Math.pow(10, l - 1);
                for (int i = l - 1; i >= 0; i--) {
                    if (Character.getNumericValue(N.charAt(i)) == d) {
                        s += x - (n % x);
                    }
                    x /= 10;
                }
                System.out.println(s);
            }
        } catch (Exception e) {

        }
    }
}
