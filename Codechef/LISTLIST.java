import java.util.Scanner;

public class LISTLIST {
    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try {
		    Scanner sc=new Scanner(System.in);
		    int t=sc.nextInt();
		    while(t-->0){
                System.out.print("No. of elements : ");
		        int n=sc.nextInt();
		        int[] a=new int[n];
                System.out.print("Elements : ");
		        for(int i=0; i<n; i++){
		            a[i]=sc.nextInt();
		        }
		        if(n==1){
		            System.out.println(0);
		            continue;
		        }
		        int[] cc=new int[200001];
		        for(int i=0; i<n; i++){
		            cc[a[i]]++;
		        }
		        int p=0;
		        for(int i=1; i<cc.length; i++){
		            if(cc[i]>1&&cc[i]>p){
		                p=cc[i];
		            }
		        }
		        if(p==0){
		            System.out.println(-1);
		        }
                else if(p==n){
                    System.out.println(0);
                }
		        else{
                    System.out.println(n-p+1);
		        }
		    }
		} catch(Exception e) {
		}
	}
}
