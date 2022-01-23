//https://leetcode.com/problems/sequential-digits/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//DFS
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        for(int i=1; i<10; i++){
            helper(res, i, low, high);
        }
        Collections.sort(res);
        return res;
    }
    
    public void helper(List<Integer> res, int num, int low, int high){
        if(num%10==0) return;
        if(num>high) return;
        if(num>=low&&num<=high){
            res.add(num);
        }
        if(num%10<=8){
            helper(res, num*10+(num%10+1), low, high);
        }
    }
}

/*
BFS soln
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=1; i<=8; i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int n = q.poll();
            if(n>=low&&n<=high){
                res.add(n);
            }
            if(n%10<=8){
                q.add(n*10+(n%10+1));
            }
        }
        return res;
    }
}
*/
