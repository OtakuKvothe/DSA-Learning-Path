//https://leetcode.com/problems/largest-merge-of-two-strings
public class LargestMergeStrings {
    public String largestMerge(String word1, String word2) {
        String res = "";
        int p1=0, p2=0;
        int n1 = word1.length(), n2 = word2.length();
        while(p1<n1&&p2<n2){
            char c1 = word1.charAt(p1), c2 = word2.charAt(p2);
            if(c1>c2){
                res+=c1;
                p1++;
            }else if(c1 == c2){
                if(word1.substring(p1, n1).compareTo(word2.substring(p2, n2))>0){
                    res+=c1;
                    p1++;
                }else{
                    res+=c2;
                    p2++;
                }
            }
            else{
                res+=c2;
                p2++;
            }
        }
        while(p1<n1){
            res+=word1.charAt(p1++);
        }
        while(p2<n2){
            res+=word2.charAt(p2++);
        }
        return res;
    }
}
