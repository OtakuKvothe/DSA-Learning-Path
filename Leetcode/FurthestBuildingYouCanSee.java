//https://leetcode.com/problems/furthest-building-you-can-reach/

public class FurthestBuildingYouCanSee {
    public int furthestBuilding(int[] h, int b, int l) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<h.length-1; i++) {
            int curr = h[i+1] - h[i];
            if(curr > 0)
                q.add(curr);
            if(q.size() > l)
                b -= q.poll();
            if(b < 0)
                return i;
        }
        return h.length-1;
    }
}
