//https://leetcode.com/problems/next-greater-element-ii

import java.util.Stack;
import java.util.Arrays;

public class NextGreatestElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for(int i=0; i<2*nums.length; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i%nums.length]) {
                res[st.pop()] = nums[i%nums.length];
            }
            if(i<nums.length) st.push(i%nums.length);
        }
        return res;
    }
}
