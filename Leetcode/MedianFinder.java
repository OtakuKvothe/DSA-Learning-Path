//https://leetcode.com/problems/find-median-from-data-stream
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> big;
    private PriorityQueue<Integer> small;
    private boolean even;

    public MedianFinder() {
        big = new PriorityQueue<>();
        small = new PriorityQueue<>(Collections.reverseOrder());
        even = true;
    }
    
    public void addNum(int num) {
        if(even){
            small.add(num);
            big.add(small.poll());
        }else{
            big.add(num);
            small.add(big.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (big.peek()+small.peek())/2.0;
        }else{
            return big.peek();
        }
    }
}
