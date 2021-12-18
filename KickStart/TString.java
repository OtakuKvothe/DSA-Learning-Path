//First time first attempt clear on Kickstart!!
//https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435914/00000000008da461

import java.io.*;
import java.util.HashMap;

class TString {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int tt = t;
        while (t-- > 0) {
            String s = br.readLine();
            String f = br.readLine();
            HashMap<Character, Boolean> map = new HashMap<>();
            for (int i = 0; i < f.length(); i++) {
                char ch = f.charAt(i);
                // System.out.println("aaaa");
                if (!map.containsKey(ch)) {
                    map.put(ch, true);
                }
            }
            // System.out.println(map.isEmpty());
            // System.out.println("bbbb");
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!map.containsKey(ch)) {
                    char chf = ch, chb = ch;
                    int tCount = 0;
                    // System.out.println("ccccc");
                    while (true) {
                        chf = (chf == 'z') ? 'a' : (char) ((int) (chf) + 1);
                        chb = (chb == 'a') ? 'z' : (char) ((int) (chb) - 1);
                        tCount++;
                        // System.out.println(chf+" "+chb);
                        // System.out.println("ddddd");
                        if (map.containsKey(chf) || map.containsKey(chb)) {
                            count += tCount;
                            // System.out.println("oooo");
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #" + (tt - t) + ": " + count);
        }
    }
}