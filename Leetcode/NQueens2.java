//https://leetcode.com/problems/n-queens-ii
public class NQueens2 {
    public int totalNQueens(int n) {
        return helper(new ArrayList<int[]>(), 0, n);
    }
    
    public int helper(List<int[]> ind, int col, int n) {
        if(col == n) {
            return 1;
        }
        int res = 0;
        for(int i=0; i<n; i++) {
            if(isValid(ind, i, col, n)) {
                ind.add(new int[]{i, col});
                res += helper(ind, col+1, n);
                ind.remove(ind.size()-1);
            }
        }
        return res;
    }
    
    public boolean isValid(List<int[]> ind, int row, int col, int n) {
        for(int[] index: ind) {
            int x = index[0], y = index[1];
            if(x+y == row+col || x+col == y+row || x == row)
                return false;
        }
        return true;
    }
}
