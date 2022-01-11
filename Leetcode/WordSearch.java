//https://leetcode.com/problems/word-search
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board, new boolean[board.length][board[0].length], i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] b, boolean[][] u, int i, int j, String s, int k){
        if(i<0||i>=b.length||j<0||j>=b[0].length||u[i][j]||k>=s.length()) return false;
        if(b[i][j]==s.charAt(k)){
            if(k==s.length()-1) return true;
            u[i][j]=true;
            if(dfs(b, u, i+1, j, s, k+1)||dfs(b, u, i-1, j, s, k+1)||dfs(b, u, i, j+1, s, k+1)||dfs(b, u, i, j-1, s, k+1)) return true;
            u[i][j]=false;
        }
        return false;
    }
}
