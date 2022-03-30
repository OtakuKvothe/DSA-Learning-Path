//https://leetcode.com/problems/search-a-2d-matrix
public class SearchInA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length-1, row = 0, col = 0;
        while(start < end) {
            row = start + (end - start)/2;
            if(target == matrix[row][0]) return true;
            if(target > matrix[row][0]) {
                start = row;
                if(target <= matrix[row][matrix[row].length-1]) break;
                else {
                    start++;
                    row++;
                }
            } else {
                end = row;
            }
        }
        start = 0; end = matrix[row].length-1;
        while(start <= end) {
            col = start + (end - start)/2;
            if(target == matrix[row][col]) return true;
            if(target > matrix[row][col]) {
                start = col + 1;
            } else {
                end = col - 1;
            }
        }
        return false;
    }
}
