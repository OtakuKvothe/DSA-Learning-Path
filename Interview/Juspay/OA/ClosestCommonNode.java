import java.util.HashMap;
import java.util.Scanner;

public class ClosestCommonNode {

    public static int closestCommonNode(int[] nodes, int N, int node1, int node2) {

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        boolean[] vis = new boolean[N];

        int mark1 = node1, mark2 = node2;
        int dist = -1;
        while(mark1 != -1 && mark1 < N && !vis[mark1]) {
            vis[mark1] = true;
            dist++;
            map1.put(mark1, dist);
            mark1 = nodes[mark1];
        }
        int res = Integer.MAX_VALUE, node = -1;
        vis = new boolean[N];
        dist = -1;
        while(mark2 != -1 && mark2 < N && !vis[mark2]) {
            vis[mark2] = true;
            dist++;
            map2.put(mark2, dist);
            mark2 = nodes[mark2];
            if(map1.containsKey(mark2)) {
                if(dist + map1.get(mark2) < res) {
                    res = dist + map1.get(mark2);
                    node = mark2;
                }
            }
        }

        if(node != -1 && res <= map1.getOrDefault(node2, Integer.MAX_VALUE) && res <= map2.getOrDefault(node1, Integer.MAX_VALUE)) {
            return node;
        } else if(map1.containsKey(node2) && map2.containsKey(node1)) {
            if(map1.get(node2) < map2.get(node1)) {
                return node2;
            } else return node1;
        } else if(map1.containsKey(node2)) {
            return node2;
        } else if(map2.containsKey(node1)) {
            return node1;
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int[] nodes = new int[n];
            for(int i=0; i<n; i++) {
                nodes[i] = sc.nextInt();
            }
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            System.out.println(closestCommonNode(nodes, n, node1, node2));
        }
        sc.close();
    }
}
