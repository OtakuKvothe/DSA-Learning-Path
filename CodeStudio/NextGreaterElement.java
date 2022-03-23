//https://www.codingninjas.com/codestudio/problems/next-greater-element_670312?leftPanelTab=1
import java.util.Stack;
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] arr, int n) 
    {
        // Write your code here.
        int p=n-1, res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0&&p>=0; i--) {
            if(s.size() == 0) {
                res[p--] = -1;
            }else if(s.size() > 0 && s.peek() > arr[i]) {
                res[p--] = s.peek();
            }else if(s.size() > 0 && s.peek() <= arr[i]) {
                while(s.size() > 0 && s.peek() <= arr[i]) {
                    s.pop();
                }
                if(s.isEmpty()) {
                    res[p--] = -1;
                } else {
                    res[p--] = s.peek();
                }
            }
            s.push(arr[i]);
        }
        return res;
    }
}
