//https://leetcode.com/problems/string-to-integer-atoi
public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        boolean neg = false;
        int sum = 0;
        char c;
        int i=0;
        while(i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        if(i<s.length()) c=s.charAt(i);
            else c='X';
        if(c=='+'){
            i++;
        }else if(c=='-'){
            neg = true;
            i++;
        }
        if(i<s.length()) c=s.charAt(i);
            else c='X';
        while(c>='0'&&c<='9'){
            int d = c-'0';
            if(sum > Integer.MAX_VALUE/10||(sum == Integer.MAX_VALUE/10&&d>Integer.MAX_VALUE%10)){
                if(neg) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            sum=sum*10+d;
            i++;
            if(i<s.length()) c=s.charAt(i);
            else c='X';
        }
        return neg?-sum:sum;
    }
}
