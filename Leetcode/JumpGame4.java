//https://leetcode.com/problems/jump-game-iv/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JumpGame4 {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        }
        boolean[] v = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        v[0]=true;
        int c=0;
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; --i){
                int ind = q.poll();
                if(ind == arr.length-1) return c;
                List<Integer> next = map.get(arr[ind]);
                next.add(ind-1);
                next.add(ind+1);
                for(int k: next){
                    if(k>=0&&k<arr.length&&!v[k]){
                        q.offer(k);
                        v[k]=true;
                    }
                }
                next.clear();
            }
            c++;
        }
        return 0;
    }
}
