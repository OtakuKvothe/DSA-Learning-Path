//https://leetcode.com/problems/largest-rectangle-in-histogram
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> s=new Stack<>();
        for(int i=0; i<=heights.length; i++){
            while(!s.isEmpty() && (i == heights.length || heights[i] < heights[s.peek()])){
                int prev = s.pop();
                if(s.isEmpty()){
                    res = Math.max(res, heights[prev] * i);
                }else{
                    res = Math.max(res, heights[prev] * (i - s.peek() - 1));
                }
            }
            s.push(i);
        }
        return res;
    }
}
