//https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435914/00000000008d9a88

import java.io.*;
import java.util.Arrays;

public class Painter {
    public static void main(String[] args) {
        try {
            //BufferedReader br=new BufferedReader(new FileReader(new File("C:/Users/Desktop/Downloads/test_data/test_set_2/ts2_input.txt")));
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int tt=1; tt<=t; tt++){
                int n=Integer.parseInt(br.readLine());
                String p = br.readLine();
                boolean[] r=new boolean[n];
                boolean[] y=new boolean[n];
                boolean[] b=new boolean[n];
                Arrays.fill(r, false);
                Arrays.fill(y, false);
                Arrays.fill(b, false);
                for(int i=0; i<n; i++){
                    char ch=p.charAt(i);
                    if(ch=='R'){
                        r[i]=true;
                    }
                    else if(ch=='Y'){
                        y[i]=true;
                    }
                    else if(ch=='B'){
                        b[i]=true;
                    }
                    else if(ch=='O'){
                        r[i]=true;
                        y[i]=true;
                    }
                    else if(ch=='P'){
                        r[i]=true;
                        b[i]=true;
                    }
                    else if(ch=='G'){
                        y[i]=true;
                        b[i]=true;
                    }
                    else if(ch=='A'){
                        r[i]=true;
                        y[i]=true;
                        b[i]=true;
                    }
                }
                int rC=0, yC=0, bC=0;
                for(int i=0; i<n; i++){
                    if((i>0&&r[i-1]&&!r[i])||(i==n-1&&r[i])){
                        rC++;
                    }
                    if((i>0&&b[i-1]&&!b[i])||(i==n-1&&b[i])){
                        bC++;
                    }
                    if((i>0&&y[i-1]&&!y[i])||(i==n-1&&y[i])){
                        yC++;
                    }
                }
                System.out.println("Case #"+tt+": "+(rC+bC+yC));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
