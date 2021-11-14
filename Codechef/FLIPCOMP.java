import java.io.*;

public class FLIPCOMP {
    public static void main(String[] args) throws java.lang.Exception{
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            while(t-->0){
                String s=br.readLine();
                if(s.length()==0||s.length()==1){
                    System.out.println(0);
                }else{
                    System.out.println(Math.min(countMoves(s, '0'), countMoves(s, '1')));
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static int countMoves(String s, char c){
        int count = 0;
        int tCount = 0, nCount=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                tCount++;
                nCount++;
            }
            if(s.charAt(i) != c || i == s.length()-1){
                if(tCount==1){
                    count+=1;
                }
                else if(tCount >= 2){
                    count+=2;
                }
                tCount=0;
            }
        }
        if(nCount==s.length()) return 0;
        return count;
    }
}
