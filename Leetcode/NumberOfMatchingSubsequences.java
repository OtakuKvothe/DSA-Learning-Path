// https://leetcode.com/problems/number-of-matching-subsequences

import java.util.ArrayList;
import java.util.HashMap;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                ArrayList<Integer> list = map.get(ch);
                list.add(i);
                map.put(ch, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch, list);
            }
        }
        // System.out.println(map);
        int res = 0;
        for (String word : words) {
            int ind = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) {
                    ind = -1;
                    break;
                }
                ind = search(map.get(c), ind);
                // System.out.println(ind);
                if (ind == -1) {
                    break;
                }
                ind++;
            }
            if (ind > -1) {
                // System.out.println(word);
                res++;
            }
        }

        return res;
    }

    public int search(ArrayList<Integer> list, int curr) {
        if (list.size() == 0)
            return -1;
        int l = 0, r = list.size() - 1;
        if (list.get(l) >= curr)
            return list.get(l);
        if (list.get(r) < curr)
            return -1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (list.get(mid) == curr)
                return curr;
            if (list.get(mid) < curr)
                l = mid + 1;
            else
                r = mid;
        }
        return list.get(r);
    }
}
