//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, hi=getMax(piles);
        while(l<=hi){
            int k = (l+hi)/2;
            if(canEat(piles, h, k)){
                hi = k-1;
            }else{
                l=k+1;
            }
        }
        return l;
    }
    
    public boolean canEat(int[] nums, int h, int k){
        int count = 0;
        for(int i: nums){
            count += i/k;
            if(i%k>0) count++;
        }
        return count <= h;
    }
    
    public int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            max = Math.max(max, i);
        }
        return max;
    }
}
