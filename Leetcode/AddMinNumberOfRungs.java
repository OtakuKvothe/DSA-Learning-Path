//https://leetcode.com/problems/add-minimum-number-of-rungs
public class AddMinNumberOfRungs {
    public int addRungs(int[] rungs, int dist) {
        int last = 0, count = 0;
        for(int rung: rungs){
            int diff = rung - last;
            if(diff > dist){
                count+=diff/dist;
                if(diff%dist == 0) count--;
            }
            last = rung;
        }
        return count;
    }
}
