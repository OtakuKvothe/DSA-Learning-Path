package TreeOfSpaceThreadSafe;

import java.util.HashMap;

import TreeOfSpaceThreadSafe.Mutex.Mutex;

public class Main {
    public static void main(String[] args) {
        Mutex lock = new Mutex();
        CLHLock lock2 = new CLHLock();
        HashMap<String, Boolean> result = new HashMap<>();
        String arr[] = {"World", "Asia", "Africa", "China", "India", "SouthAfrica", "Egypt"};
        String queries[] = {"1 China 9", "1 India 9", "3 Asia 9", "2 India 9", "2 Asia 9"};
        int n = 7, m = 2;

        TreeOfSpace treeOfSpace = new TreeOfSpace(m, arr);

        for(String query: queries) {
            (new Thread(new TreeQuery(treeOfSpace, lock2, query, result))).start();
            try {
                //Thread.currentThread().sleep(10);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        try {
            Thread.currentThread().sleep(5000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println(result);
    }
}
/**
 * Input: N = 7, M = 2, nodes = {"World", "Asia", "Africa", "China", "India", "SouthAfrica", "Egypt"},  
queries =  {"1 China 9", "1 India 9", "3 Asia 9", "2 India 9", "2 Asia 9"}
Output: true true true false true

Input: N = 3, M = 2, nodes = [‘World’, ‘China’, ‘India’],  
queries =  [‘3 India 1’, ‘1 World 9’]
Output: false true
 */