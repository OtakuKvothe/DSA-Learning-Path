// https://leetcode.com/problems/132-pattern

import java.util.Stack;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int t = Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] < t) return true;
            while(!st.isEmpty() && st.peek() < nums[i]) t = st.pop();
            st.push(nums[i]);
        }
        return false;
    }
}
