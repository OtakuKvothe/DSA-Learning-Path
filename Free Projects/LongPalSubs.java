//Longest Palindromic Substring

public class LongPalSubs {

    //much faster solution
    public String longestPalindrome(String s) {
        int n = s.length();
        int l=0, r=0;
        for(int i=0; i<n; i++){

            //we will check if there are any palindromic strings with position i as the centre. In case of even length with i and i+1 as centre. If we find a palindromic string, we will expand the substring one char either side if they satisfy condition of palindrome.

            int l1 = growPalindrome(s, i, i);//odd length
            int l2 = growPalindrome(s, i, i+1);//even length
            int ln = Math.max(l1, l2);
            if(ln>r-l){
                l=i-(ln-1)/2;
                r=i+ln/2;
            }
        }
        return s.substring(l, r+1);
    }

    private int growPalindrome(String s, int l, int r){
        
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }

    /*
    //DP Soln 1. Easy to understand but O(n^2)
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==1) return s;
        boolean[][] board = new boolean[n][n];

        int max = 1;
        String maxStr = String.valueOf(s.charAt(0));

        //substrings of length 1
        for(int i=0; i<n; i++){
            board[i][i]=true;
        }

        //substrings of length 2
        for(int i=0; i<n-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                board[i][i+1]=true;
                max = 2;
                maxStr = s.substring(i,i+2);
            }
        }

        

        for(int k=3; k<=n; k++){
            for(int i=0; i<n-k+1;i++){
                int j = i+k-1;
                if(board[i+1][j-1]&&s.charAt(i)==s.charAt(j)){
                    board[i][j]=true;                   
                    if(k>max){
                        maxStr = s.substring(i, j+1);
                    }
                }
            }
        }

        return maxStr;
    }
    */
}
