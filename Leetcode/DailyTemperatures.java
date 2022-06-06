//https://leetcode.com/problems/daily-temperatures

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> st = new LinkedList<>();
        int[] res = new int[T.length];
        for(int i = T.length-1; i >= 0; i--) {
            while(!st.isEmpty() && T[st.peek()] <= T[i]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                res[i] = st.peek()-i;
            }
            st.push(i);
        }
        return res;
    }
}
