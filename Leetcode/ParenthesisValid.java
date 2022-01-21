//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid
public class ParenthesisValid {
    public int minAddToMakeValid(String st) {
        int c=0, s=0;
        for(char ch: st.toCharArray()){
            if(ch=='(') c++;
            else{
                if(c==0) s++;
                else c--;
            }
        }
        return c+s;
    }
}
