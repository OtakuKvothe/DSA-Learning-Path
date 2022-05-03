//https://leetcode.com/problems/evaluate-division/

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

    class Pair<T1, T2> {
         
        T1 vertex;
        T2 weight;
        
        public Pair(T1 vertex, T2 weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //Make an adjacency list for storing neighbour and weight of edge to the neighbour
        Map<String, HashSet<Pair<String, Double>>> adj = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0), v = equation.get(1);
            
            HashSet<Pair<String, Double>> ue = adj.getOrDefault(u, new HashSet<>());
            ue.add(new Pair<>(v, values[i]));
            adj.put(u, ue);
            
            HashSet<Pair<String, Double>> ve = adj.getOrDefault(v, new HashSet<>());
            ve.add(new Pair<>(u, 1/values[i]));
            adj.put(v, ve);
        }
        
        double[] res = new double[queries.size()];
        
        for(int i=0; i<queries.size(); i++) {
            res[i] = getVal(queries.get(i).get(0), queries.get(i).get(1), adj, new HashSet<String>());
        }
        
        return res;
    }
    
    //dfs call to find the final node. Shortest path is not needed as it will not affect result
    public double getVal(String start, String end, Map<String, HashSet<Pair<String, Double>>> adj, HashSet<String> vis) {
        //if given string does not exist
        if(!adj.containsKey(start)) return -1d;

        vis.add(start);
        
        for(Pair<String, Double> p: adj.get(start)) {
            String n = p.vertex;
            double w = p.weight;

            //if we are at destination
            if(n.equals(end)) return w;

            if(!vis.contains(n)) {
                double res = getVal(n, end, adj, vis);
                
                if(res != -1.0) {
                    return res * w;
                }
            }
        }
        
        return -1d;
    }
}
