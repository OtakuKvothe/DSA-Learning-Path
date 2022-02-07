import java.util.Scanner;

//https://leetcode.com/problems/nth-magical-number/submissions/

public class nMagic {
    public static int nthMagicalNumber(int n, int a, int b) {
        long aa = a, bb = b, r = 0, mod = (long)Math.pow(10, 9)+7;
        
        while(bb>0){
            long t=aa;
            aa=bb;
            bb=t%bb;
        }
        
        long gcd = aa;
        long lcm = a*b/aa;
        
        System.out.println("Gcd: "+gcd+" lcm: "+lcm);
        
        long x = lcm/a + lcm/b - 1;
        
        long nn = n/x;
        long f = n%x;
        
        long ff = 0; r = nn * lcm;
        
        int ii=1, jj=1;
        
        for(int i=1; i<=f; i++){
            if(a*ii<b*jj){
                ff=a*ii;
                ii++;
            }else{
                ff=b*jj;
                jj++;
            }
        }
        
        return (int)((r+ff)%mod);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(nthMagicalNumber(n, a, b));
        }
        sc.close();
    }
}
