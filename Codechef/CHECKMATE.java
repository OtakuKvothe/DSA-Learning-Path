import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CHECKMATE {
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
		try{
		    FastReader fr = new FastReader();
		    PrintWriter out = new PrintWriter(System.out);
		    int t=fr.nextInt();
		    while(t-->0){
		        int xk=fr.nextInt();
		        int yk=fr.nextInt();
		        int x1=fr.nextInt();
		        int y1=fr.nextInt();
		        int x2=fr.nextInt();
		        int y2=fr.nextInt();
                String ans = "NO";
                if(!(xk==1||xk==8||yk==1||yk==8)){
		            ans = "NO";
		        }
                else{
                    if(xk==1){
                        if((x1==2||x2==2)&&y1!=y2){
                            if(Math.abs(y1-yk)>1&&Math.abs(y2-yk)>1){
                                ans="YES";
                            }
                        }
                    }else if(xk==8){
                        if((x1==7||x2==7)&&y1!=y2){
                            if(Math.abs(y1-yk)>1&&Math.abs(y2-yk)>1){
                                ans="YES";
                            }
                        }
                    }

                    if(yk==1){
                        if((y1==2||y2==2)&&x1!=x2){
                            if(Math.abs(x1-xk)>1&&Math.abs(x2-xk)>1){
                                ans="YES";
                            }
                        }
                    }else if(yk==8){
                        if((y1==7||y2==7)&&x1!=x2){
                            if(Math.abs(x1-xk)>1&&Math.abs(x2-xk)>1){
                                ans="YES";
                            }
                        }
                    }
                }
                System.out.println(ans);
		    }
		}catch(Exception e){
            e.printStackTrace();
        }
	}
}
