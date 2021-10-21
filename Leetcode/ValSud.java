import java.util.Scanner;

//36. Valid Sudoku

public class ValSud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 0; j++) {
                char x = sc.next().charAt(0);
                grid[i][j] = (x == '.') ? 0 : Character.getNumericValue(x);
            }
        }

        boolean flag = true;

        for (int i = 0; i < 9; i++) {
            int sumR = 0, sumC = 0;
            for (int j = 0; j < 9; j++) {
                sumR += grid[i][j];
                sumC += grid[i][j];
            }

        }
    }
}
