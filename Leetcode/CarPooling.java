//https://leetcode.com/problems/car-pooling/submissions/
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] people = new int[1001];
        for(int i=0; i<trips.length; i++){
            people[trips[i][1]]+=trips[i][0];
            people[trips[i][2]]-=trips[i][0];
        }
        for(int v: people){
            capacity-=v;
            if(capacity<0) return false;
        }
        return true;
    }
}
