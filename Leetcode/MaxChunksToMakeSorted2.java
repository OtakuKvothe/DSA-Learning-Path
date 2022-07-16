//https://leetcode.com/problems/max-chunks-to-make-sorted-ii

import java.util.Stack;

public class MaxChunksToMakeSorted2 {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            int max = arr[i];
            while(!st.isEmpty() && st.peek() > arr[i]) {
                max = Math.max(max, st.pop());
            }
            st.push(max);
        }
        return st.size();
    }
}
