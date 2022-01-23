//https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
import java.util.ArrayList;
import java.util.List;

public class Recon2RBinaryArr {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        if(upper+lower != sum(colsum)) return res;
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for(int i=0; i<colsum.length; i++){
            int u, l, c=colsum[i];
            if(c==0){
                u=0;
                l=0;
            }else if(c==2){
                u=1;
                upper--;
                l=1;
                lower--;
            }else{
                if(upper>lower){
                    u=1;
                    l=0;
                    upper--;
                }else{
                    l=1;
                    u=0;
                    lower--;
                }
            }
            if(upper<0 || lower<0) return new ArrayList<>();
            res.get(0).add(u);
            res.get(1).add(l);
        }
        return res;
    }
    
    public int sum(int[] n){
        int s=0;
        for(int i: n){
            s+=i;
        }
        return s;
    }
}
