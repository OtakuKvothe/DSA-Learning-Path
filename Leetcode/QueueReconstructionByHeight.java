// https://leetcode.com/problems/queue-reconstruction-by-height
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return - a[0] + b[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int p[]: people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][2]);
    }
}
