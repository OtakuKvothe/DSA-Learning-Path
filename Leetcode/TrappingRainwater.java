//https://leetcode.com/problems/trapping-rain-water
public class TrappingRainwater {
    public int trap(int[] h) {
        int n = h.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        int maxL=0, maxR=0, sum=0;
        for(int i=0; i<n; i++){
            int l=i, r=n-1-i;
            maxL=Math.max(maxL, h[l]);
            maxR=Math.max(maxR, h[r]);
            pref[l]=maxL-h[l];
            suff[r]=maxR-h[r];
        }
        for(int i=0; i<n; i++){
            sum+=Math.min(pref[i], suff[i]);
        }
        return sum;
    }
}
