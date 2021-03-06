//https://leetcode.com/problems/find-k-closest-elements
import java.util.ArrayList;
import java.util.List;

public class FindKColsestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0, r=arr.length-k;
        while(l<r) {
            int mid = (l+r)/2;
            if(x-arr[mid]>arr[mid+k]-x) l=mid+1;
            else r=mid;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=l; i<l+k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
