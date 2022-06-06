// https://leetcode.com/problems/n-queens

import java.util.List;
import java.util.ArrayList;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        helper(board, res, 0);
        return res;
    }
    
    public void helper(char[][] board, List<List<String>> res, int col) {
        if(col == board.length) {
            res.add(makeBoard(board));
            return;
        }
        
        for(int i=0; i<board.length; i++) {
            if(isValid(board, i, col)) {
                board[i][col] = 'Q';
                helper(board, res, col+1);
                board[i][col] = '.';
            }
        }
    }
    
    public boolean isValid(char[][] board, int x, int y) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'Q' && (x+j == y+i || x+y == i+j || x == i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public List<String> makeBoard(char[][] board) {
        List<String> boardList = new ArrayList<>();
        for(char[] row: board) {
            boardList.add(new String(row));
        }
        return boardList;
    }

    public static void main(String[] args) {
        NQueens ob = new NQueens();
        System.out.println(ob.solveNQueens(8));
    }
}
