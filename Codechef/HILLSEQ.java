/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try {
		    Scanner sc=new Scanner(System.in);
		    int t=sc.nextInt();
		    while(t-->0){
		        int n=sc.nextInt();
		        TreeMap<Integer, Integer> map = new TreeMap<>();
		        int max = Integer.MIN_VALUE;
		        for(int i=0; i<0; i++){
		            int k=sc.nextInt();
		            if(!map.containsKey(k)){
		                map.put(k, 1);
		            }
		            else{
		                map.put(k, map.get(k)+1);
		            }
		            max=(k>=max)?k:max;
		        }
		        int[] res = new int[n];
		        int l=0, r=n-1;
		        for(TreeMap<Integer, Integer> key: map.keySet()){
                    int freq = map.get(key);
                    if(freq==1){
                        res[r]=freq;
                        res--;
                    }
                    else{
                        if(freq==2){
                            res[l]=key;
                            res[r]=key;
                            l++;
                            r--;
                        }
                    }
                }
		    }
		} catch(Exception e) {
		}
	}
}
