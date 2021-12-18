import java.util.Scanner;

//https://leetcode.com/problems/sort-colors/
public class SortColors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }
            sortColors(num);
            for(int i: num){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void sortColors(int[] nums) {
        if(nums.length == 0||nums.length==1) return;
        if(nums.length == 2 && nums[0]<nums[1]) return;
        int low = 0, mid = 0, high = nums.length - 1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums, low++, mid++);
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums, high--, mid);
            }
        }
    }
    
    public static void swap(int[] n, int i, int j){
        int t = n[i];
        n[i]=n[j];
        n[j]=t;
    }
}
