import java.io.*;
import java.util.*;
import java.lang.*;

public class XOREQN {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    //Not clearing all test cases

    public static void main(String[] args) throws java.lang.Exception {
        try {
            FastReader fr=new FastReader();
            int t=fr.nextInt();
            while(t-->0){
                int n=fr.nextInt();
                if(n==1){
                    System.out.println(-1);
                    continue;
                }
                long[] a=new long[n];
                long xSum = 0;
                boolean isIdentical = true;
                for(int i=0; i<n; i++){
                    a[i]=fr.nextLong();
                    xSum=xSum^a[i];
                    if(i>0&&a[i]!=a[i-1]){
                        isIdentical=false;
                    }
                }
                if(isIdentical){
                    System.out.println(-1);
                    continue;
                }
                if(xSum%n==0){
                    System.out.println(xSum/n);
                }
                else{
                    System.out.println(-1);
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
