//https://leetcode.com/problems/broken-calculator
public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        int num = target, count = 0;
        if(startValue > target) return startValue - target;
        while(num > startValue) {
            if(num % 2 == 0 && num > startValue) {
                num /= 2;
            } else {
                num++;
            }
            count++;
        }
        return count + startValue - num;
    }
}
