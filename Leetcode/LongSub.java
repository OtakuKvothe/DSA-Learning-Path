
import java.util.HashMap;
import java.util.Scanner;

public class LongSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(lengthOfLongestSubstring(s));
        }
        sc.close();
    }

    public static int lengthOfLongestSubstring(String s) {
        int l = 0, r = 1, sum = 1;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        map.put(s.charAt(l), l);

        for (; r < s.length(); r++) {

            // INteger can be null but primitive type int cannot be null
            Integer x = map.get(s.charAt(r));

            if (x == null || x < l) {
                sum = Math.max(sum, r - l + 1);
            } else {
                l = x + 1;
            }

            map.put(s.charAt(r), r);
        }
        return sum;
    }
}