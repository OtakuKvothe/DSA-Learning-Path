import java.util.*;
import java.lang.*;

public class MAXBRIDGE {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int e = 0;

                // create a chain (only bridges)
                for (int i = 1; i <= n - 1; i++) {
                    System.out.println(i + " " + (i + 1));
                    e++;
                }

                // fill up extra edges in order
                a: for (int j = 3; j <= n; j++) {
                    if (e < m) {
                        for (int g = j - 2; g > 0 && g != j - 1; g--) {
                            if (e < m) {
                                System.out.println(g + " " + j);
                                e++;
                            } else {
                                break a;
                            }
                        }
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
