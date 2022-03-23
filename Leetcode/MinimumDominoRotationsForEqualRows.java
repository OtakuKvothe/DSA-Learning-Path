//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row
public class MinimumDominoRotationsForEqualRows {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] cTop = new int[6], cBot = new int[6], same = new int[6];
        int n=tops.length;
        for(int i=0; i<n; i++){
            cTop[tops[i]-1]++;
            cBot[bottoms[i]-1]++;
            if(tops[i]==bottoms[i]) same[tops[i]-1]++;
        }
        for(int i=0; i<6; i++){
            if(cTop[i]+cBot[i]-same[i]>=n){
                return Math.min(cTop[i], cBot[i])-same[i];
            }
        }
        return -1;
    }
}
