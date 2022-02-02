//https://leetcode.com/problems/kth-largest-element-in-a-stream
import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    private int k;
    private PriorityQueue<Integer> pq;
    
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
