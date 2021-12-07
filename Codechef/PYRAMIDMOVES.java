import java.util.*;

public class PYRAMIDMOVES {

    final static int MOD = (int) Math.pow(10, 9) + 7;
    static HashMap<Integer, int[]> index = new HashMap<>();
    static HashMap<Integer, Long> fact = new HashMap<>();

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            // index[x][0]=level, index[x][1]=index
            int[] res = { 1, 1 };
            index.put(1, res);
            fact.put(0, (long) 1);
            fact.put(1, (long) 1);
            for (int i = 2; i <= 100000; i++) {
                long x = fact(i);
                fact.put(i, x);
                // System.out.println(fact.get(i));
            }
            while (t-- > 0) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                if (s >= e) {
                    System.out.println(0);
                    continue;
                }
                int sl, si, el, ei;
                int sx[] = getIndex(s);
                int ex[] = getIndex(e);
                sl = sx[0];
                si = sx[1];
                el = ex[0];
                ei = ex[1];
                // System.out.println("sl: "+sl+" si:"+si+" el:"+el+" ei:"+ei);
                int d = el - sl;
                int dr = ei - si;
                // System.out.println("d:"+d+" dr:"+dr);
                if (dr > d || d <= 0 || dr < 0) {
                    System.out.println(0);
                    continue;
                }
                // int fd=fact(d);
                // int fdr=fact(dr);
                // int fddr=fact(d-dr);
                long ans = nCr((long) d, (long) dr, (long) MOD);
                System.out.println(ans);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    static long fact(int num) {
        // System.out.println("Fact: "+num);
        if (num == 0 || num == 1)
            return 1;
        if (fact.containsKey(num)) {
            return fact.get(num);
        }
        long tt = num * fact(num - 1) % MOD;
        // System.out.println("tt: "+tt);
        fact.put(num, tt);
        return tt;
    }

    static int[] getIndex(int num) {
        // System.out.println("GetIndex: "+num);
        if (index.containsKey(num)) {
            return index.get(num);
        }
        int l = 0, in = 0;
        for (int i = 1; i <= num / 2; i++) {
            int ss = i * (i + 1) / 2;
            int ss2 = (i + 2) * (i + 1) / 2;
            // System.out.println("ss:"+ss+" ss2:"+ss2);
            if (num > ss && num < ss2) {
                l = i + 1;
                in = num - ss;
                break;
            }
            if (num == ss2) {
                l = i + 1;
                in = i + 1;
                break;
            }
        }
        // System.out.println("l:"+l+" in:"+in);
        int[] rr = { l, in };
        index.put(num, rr);
        return rr;
    }

    //Euler's method
    static long power(long a, long b, long mod) {
        a %= mod;
        if (a == 0)
            return 0;
        long prod = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                prod *= a;
                prod %= mod;
                --b;
            }
            a *= a;
            a %= mod;
            b /= 2;
        }
        return prod;
    }

    static long mod_inv(long n, long mod) {
        return power(n, mod - 2, mod);
    }

    static long nCr(long n, long k, long mod) {
        return ((fact.get((int) n) * mod_inv(fact.get((int) k), mod) % mod) * mod_inv(fact.get((int) (n - k)), mod))
                % mod;
    }
}
