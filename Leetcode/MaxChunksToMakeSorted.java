//https://leetcode.com/problems/max-chunks-to-make-sorted/

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int res = 0, currMax = -1;
        for(int i=0; i<arr.length; i++) {
            currMax = Math.max(currMax, arr[i]);
            if(currMax == i)
                res++;
        }
        return res;
    }
}
