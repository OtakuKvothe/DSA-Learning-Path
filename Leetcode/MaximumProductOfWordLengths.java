// https://leetcode.com/problems/maximum-product-of-word-lengths

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] counts = new int[n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<words[i].length(); j++) {
                counts[i] |= 1 << (words[i].charAt(j)-'a');
            }
        }
        int res = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if((counts[i]&counts[j])==0 && words[i].length()*words[j].length() > res) {
                    res = Math.max(res, words[i].length()*words[j].length());
                }
            }
        }

        return res;
    }
}
