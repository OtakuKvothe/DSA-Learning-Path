import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class MAKEPAL
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try {
		    Scanner sc = new Scanner(System.in);
		    int t = sc.nextInt();
		    while(t-->0){
		        int n = sc.nextInt();
		        if(n==1){
		            System.out.println(0);
		            return;
		        }
		        int[] A=new int[n];
		        int odd = 0, N=0;
		        for(int i=0; i<n; i++){
		            A[i]=sc.nextInt();
		            if(A[i]%2!=0) odd++;
		            N+=A[i];//compute total length of the result string
		        }
		        int ops = 0;
		        if(N%2==0){
		            if(odd==0) ops = 0;
		            else ops = odd/2;
		        }
		        else{
		            ops=odd/2;
		        }
		        System.out.println(ops);
		    }
		} catch(Exception e) {
		}
	}
}