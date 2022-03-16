//https://leetcode.com/problems/validate-stack-sequences
import java.util.Stack;

public class ValidateStackSwquence {

    //plain simulation using stack
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i=0;
        for(int x: pushed){
            st.push(x);

            //simply make a stack and keep emptying it everytime it matches the pattern for popped
            while(!st.isEmpty()&&st.peek()==popped[i]){
                st.pop();
                i++;
            }
        }
        return st.isEmpty();
    }

    //using the pushed array as the stack
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int i=0, j=0;
        for(int x: pushed){
            pushed[i++]=x;
            while(i>0&&pushed[i-1]==popped[j]){
                --i;
                ++j;
            }
        }
        return i==0;
    }
}
