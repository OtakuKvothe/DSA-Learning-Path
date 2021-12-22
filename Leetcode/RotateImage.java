import java.util.Scanner;
//https://leetcode.com/problems/rotate-image/
public class RotateImage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    mat[i][j]=sc.nextInt();
                }
            }
            rotate(mat);
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(mat[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    public static void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j = i; j<matrix[i].length; j++){
                swapT(matrix, i, j);
            }
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length/2; j++){
                swapH(matrix, i, j);
            }
        }
    }

    public static void swapT(int[][] matrix, int i, int j){
        int t = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = t;
    }

    public static void swapH(int[][] matrix, int i, int j){
        int t = matrix[i][j];
        matrix[i][j] = matrix[i][matrix[i].length - j - 1];
        matrix[i][matrix[i].length - j - 1] = t;
    }
}
