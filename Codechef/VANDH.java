import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VANDH {
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
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try {
		    FastReader sc=new FastReader();
		    int t=sc.nextInt();
		    while(t-->0){
		        int n=sc.nextInt();
		        int m=sc.nextInt();
		        int num=0;
		        String res="";
		        if(n==m){
		            num=n+m+2;
		            for(int i=1; i<=num/2; i++){
		                res+="01";
		            }
		        }
		        else if(n-m==1){
		            for(int i=1; i<=n; i++){
		                res+="01";
		            }
		            res+="0";
		        }
		        else if(m-n==1){
		            for(int i=1; i<=m; i++){
		                res+="10";
		            }
		            res+="1";
		        }
		        else{
		            if(n>m){
		                while(m>=0){
		                    res+="01";
		                    m--;
                            n--;
		                }
                        if(res.length()>0) res+="0";
		                while(n>0){
		                    res+="010";
		                    n--;
		                }
		            }else if(m>n){
		                while(n>=0){
		                    res+="10";
		                    n--;
                            m--;
		                }
                        if(res.length()>0) res+="1";
		                while(m>0){
		                    res+="101";
		                    m--;
		                }
		            }
		        }
		        System.out.println(res.length());
		        System.out.println(res);
		    }
		} catch(Exception e) {
		}
	}
}
