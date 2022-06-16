import java.util.List;
import java.util.ArrayList;

public class ValidP {
    public static void main(String[] args) {
        int k = 100;
        System.out.println(combinations(k));
    }

    static List<String> combinations(int n) {
        List<String> res = new ArrayList<>();
        addChar("", n, n, res, n);
        return res;
    }

    static void addChar(String s, int op, int cl, List<String> res, int n) {
        

        if(cl < op || op < 0 || cl < 0) {
            return;
        }

        addChar(s+'(', op-1, cl, res, n);
        addChar(s+')', op, cl-1, res, n);

        if(op == 0 && cl == 0) {
            res.add(s);
            return;
        }
    }
}
