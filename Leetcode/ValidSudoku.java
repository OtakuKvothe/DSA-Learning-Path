//https://leetcode.com/problems/valid-sudoku
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9){
            return false;
        }
        
        Set<Integer> rows[] = new HashSet[9];
        Set<Integer> cols[] = new HashSet[9];
        Set<Integer> sb[][] = new HashSet[3][3];
        for(int i=0; i<9; i++){
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                sb[i][j] = new HashSet<Integer>();
            }
        }
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.') continue;
                int n = board[i][j]-'0';
                if(rows[i].contains(n)||cols[j].contains(n)||sb[i/3][j/3].contains(n)){
                    return false;
                }else{
                    rows[i].add(n);
                    cols[j].add(n);
                    sb[i/3][j/3].add(n);
                }
            }
        }
        return true;
    }
}
