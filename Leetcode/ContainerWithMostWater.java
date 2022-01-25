//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int w = 0;
            if (height[l] < height[r]) {
                w = height[l] * (r - l);
                l++;
            } else {
                w = height[r] * (r - l);
                r--;
            }
            max = Math.max(max, w);
        }
        return max;
    }
}
