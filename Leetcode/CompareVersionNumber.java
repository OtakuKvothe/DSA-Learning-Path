//https://leetcode.com/problems/compare-version-numbers/
public class CompareVersionNumber {
    public int compareVersion(String v1, String v2) {
        int l1 = v1.length(), l2 = v2.length();
        int n1 = 0, n2 = 0;
        int p1=0, p2=0;
        while(p1 < l1 || p2 < l2){
            n1=0;
            while(p1<l1&&v1.charAt(p1) != '.'){
                n1 = n1*10+(int)(v1.charAt(p1++)-'0');
            }
            p1++;
            n2=0;
            while(p2<l2&&v2.charAt(p2) != '.'){
                n2 = n2*10 + (int)(v2.charAt(p2++)-'0');
            }
            p2++;
            if(n1<n2) return -1;
            else if(n1>n2) return 1;
        }
        return 0;
    }
}

