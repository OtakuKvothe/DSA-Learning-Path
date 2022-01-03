//https://leetcode.com/problems/keys-and-rooms/
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        HashSet<Integer> c = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int r = q.poll();
            if(!c.contains(r)){
                c.add(r);
                List<Integer> l = rooms.get(r);
                for(Integer t: l){
                    q.add(t);
                }
            }
        }
        return c.size() == rooms.size();
    }
}
