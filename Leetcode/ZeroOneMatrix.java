//https://leetcode.com/problems/01-matrix
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i, j});
                }
                else mat[i][j]=Integer.MAX_VALUE;
            }
        }
        
        while(!q.isEmpty()){
            int[] c=q.poll();
            for(int[] dir: dirs){
                int row=c[0]+dir[0];
                int col=c[1]+dir[1];
                if(row<0||row>=mat.length||col<0||col>=mat[0].length||mat[row][col]<=mat[c[0]][c[1]]+1)
                    continue;
                q.offer(new int[]{row, col});
                mat[row][col]=mat[c[0]][c[1]]+1;
            }
        }
        return mat;
    }
}
