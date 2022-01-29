//https://leetcode.com/problems/zigzag-conversion
public class ZigZagConversion {
    public String convert(String s, int n) {
        StringBuffer[] res = new StringBuffer[n];
        for(int i=0; i<n; i++){
            res[i]=new StringBuffer();
        }
        int p=0;
        while(p<s.length()){
            for(int i=0; i<n&&p<s.length(); i++){
                res[i].append(s.charAt(p++));
            }
            for(int i=n-2; i>=1&&p<s.length(); --i){
                res[i].append(s.charAt(p++));
            }
        }
        StringBuffer out = new StringBuffer();
        for(StringBuffer t: res){
            out.append(t);
        }
        return out.toString();
    }
}
