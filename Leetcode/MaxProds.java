//https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
public class MaxProds {
    public int minimizedMaximum(int n, int[] quantities) {
        int l=1, h=getMax(quantities);
        while(l<=h){
            int x = (l+h)/2;
            if(canDist(n, x, quantities)){
                h=x-1;
            }else{
                l=x+1;
            }
        }
        return l;
    }
    
    public boolean canDist(int n, int x, int nums[]){
        int c=0;
        for(int i: nums){
            c+=i/x;
            if(i%x>0) c++;
        }
        return c<=n;
    }
    
    public int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            max = Math.max(max, i);
        }
        return max;
    }
}
