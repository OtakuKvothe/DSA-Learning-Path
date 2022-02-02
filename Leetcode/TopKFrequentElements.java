//https://leetcode.com/problems/top-k-frequent-elements
import java.util.PriorityQueue;

public class TopKFrequentElements {
    class Tup{
        int el;
        int freq;
        
        public Tup(int el, int freq){
            this.el = el;
            this.freq = freq;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        int[] buck = new int[100000];
        for(int num: nums){
            buck[num-1+50000]++;
        }
        PriorityQueue<Tup> pq = new PriorityQueue<>((a, b) -> -Integer.compare(a.freq, b.freq));
        for(int i=0; i<buck.length; i++){
            if(buck[i]>0){
                pq.add(new Tup(i+1-50000, buck[i]));
            }
        }
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i]=pq.poll().el;
        }
        return res;
    }
}
