//https://leetcode.com/problems/game-of-life
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] x={{-1, -1, -1},
                 {0, 0, 0},
                 {1, 1, 1}};
        int[][] y={{-1, 0, 1},
                {-1, 0, 1},
                {-1, 0, 1}};
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int n=0;
                for(int xx=0; xx<3; xx++){
                    for(int yy=0; yy<3; yy++){
                        if(xx==1&&yy==1) continue;
                        if(i+x[xx][yy]>=0&&i+x[xx][yy]<board.length&&j+y[xx][yy]>=0&&j+y[xx][yy]<board[0].length){
                            int nn=board[i+x[xx][yy]][j+y[xx][yy]];
                            //-1: was dead in prev state, alive in next
                            //-2: was alive in last state, dead in next
                            if(nn==-1) n+=0;
                            else if(nn==-2) n+=1;
                            else n+=nn;
                        }
                    }
                }
                if(board[i][j]==1){
                    if(n<2||n>3){
                        board[i][j]=-2;
                    }
                }else{
                    if(n==3){
                        board[i][j]=-1;
                    }
                }
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==-1) board[i][j]=1;
                else if(board[i][j]==-2) board[i][j]=0;
            }
        }
    }
}
