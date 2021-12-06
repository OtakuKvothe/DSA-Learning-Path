import java.util.*;

public class PYRAMIDMOVES {
    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            List<Integer[]> adj=new ArrayList<Integer[]>();
            adj.add(new Integer[2]);
            int nC=1;
            while(t-->0){
                int s=sc.nextInt();
                int e=sc.nextInt();
                int x=adj.size();
                if(e>x){
                    for(int i=0; i<e-x; i++){
                        Integer tt[]={++nC, ++nC};
                        adj.add(tt);
                    }
                }
                for(int i=0; i<adj.size(); i++){
                    Integer[] tt=adj.get(i);
                    System.out.println(i+": "+tt[0]+", "+tt[1]);
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
