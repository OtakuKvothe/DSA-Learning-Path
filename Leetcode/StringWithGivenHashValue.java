//https://leetcode.com/problems/find-substring-with-given-hash-value

//Look up rolling hash method

public class StringWithGivenHashValue {
    public String subStrHash(String s, int p, int m, int k, int hashValue) {
        long curr = 0, pow = 1;
        int res = 0, n = s.length();
        for(int i=n-1; i>=0; i--){
            curr = (curr*p + s.charAt(i)-'a'+1)%m;
            if(i+k >= n){
                pow = pow*p%m;
            }else{
                curr = (curr - (s.charAt(i+k)-'a'+1)*pow%m + m)%m;
            }
            if(curr==hashValue){
                res=i;
            }
        }
        
        return s.substring(res, res+k);
    }
}
