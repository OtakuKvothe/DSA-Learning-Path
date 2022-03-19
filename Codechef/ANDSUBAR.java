import java.util.Scanner;

public class ANDSUBAR {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                if (n == 1) {
                    System.out.println(1);
                    continue;
                }
                int f = 0;
                for (int i = 1; i < n; i++) {
                    double x = Math.pow(2, i) - 1;
                    if (x > n) {
                        f = i - 1;
                        break;
                    }
                }
                if (Math.pow(2, f) - Math.pow(2, f - 1) >= n - Math.pow(2, f)) {
                    System.out.println((int) (Math.pow(2, f) - Math.pow(2, f - 1)));
                } else {
                    System.out.println((int) (n - Math.pow(2, f)));
                }
            }
            sc.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
