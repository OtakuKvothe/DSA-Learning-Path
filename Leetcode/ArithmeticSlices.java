//https://leetcode.com/problems/arithmetic-slices
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;
        int n = 2, res = 0;
        for (int i = 2; i < nums.length; i++) {
            n = (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) ? n + 1 : 2;
            res += (n >= 3) ? n - 2 : 0;
        }
        return res;
    }
}
