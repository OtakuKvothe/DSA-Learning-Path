
//https://leetcode.com/problems/minimum-genetic-mutation
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumGeneticMutations {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for (String word : bank) {
            set.add(word);
        }
        HashSet<String> vis = new HashSet<>();
        char[] ch = new char[] { 'A', 'C', 'G', 'T' };
        Queue<String> q = new LinkedList<>();
        int res = 0;
        q.add(start);
        vis.add(start);
        while (!q.isEmpty()) {
            int l = q.size();
            while (l-- > 0) {
                String curr = q.poll();
                if (curr.equals(end))
                    return res;
                for (int i = 0; i < 8; i++) {
                    char[] next = curr.toCharArray();
                    for (int j = 0; j < 4; j++) {
                        next[i] = ch[j];
                        String tmp = new String(next);
                        if (set.contains(tmp) && !vis.contains(tmp)) {
                            vis.add(tmp);
                            q.add(tmp);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
