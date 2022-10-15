/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
*/
import java.util.*;
class Solution {
     public static void main(String[] args) {
        String s = "aa", p = "a*";
        int[][] memo = new int[s.length()+1][p.length()+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        boolean res = solve(s, p, 0, 0, memo);
        System.out.println(res);
     }

     private static boolean solve(String s, String p, int sIndex, int pIndex, int[][] memo) {
        int n = s.length();
        if(pIndex == p.length()) return n == sIndex;

        if(memo[sIndex][pIndex] != -1) {
            return memo[sIndex][pIndex] == 1;
        }

        if(p.charAt(pIndex) == '*') {
            for(int k = sIndex; k <= n; k++) {
                return memo[sIndex][pIndex] = solve(s, p, k, pIndex+1, memo) ? 1 : 0;
            }
        }
        if(sIndex < n && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.')) {
            return memo[sIndex][pIndex] = solve(s, p, sIndex+1, pIndex+1, memo) ? 1 : 0;
        }
        memo[sIndex][pIndex] = 0;
        return false;
     }
}