//https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk
public class FindTheStudentThatWillReplaceTheChalk {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int i=0; i<chalk.length; i++) {
            sum += chalk[i];
        }
        k %= sum;
        int i=0;
        while(true) {
            if(k - chalk[i] < 0) return i;
            k -= chalk[i++];
        }
    }
}
