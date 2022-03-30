//https://leetcode.com/problems/boats-to-save-people
import java.util.Arrays;
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, count = 0;;
        while(left<=right) {
            if(people[left]+people[right]<=limit){
                left++;
            }
            right--;
            count++;
        }
        return count;
    }
}
