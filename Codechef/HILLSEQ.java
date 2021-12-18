/* package codechef; // don't place package name! */

//It always gets stuck on something stupid.

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class HILLSEQ {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                TreeMap<Integer, Integer> map = new TreeMap<>();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    int k = sc.nextInt();
                    if (!map.containsKey(k)) {
                        map.put(k, 1);
                    } else {
                        map.put(k, map.get(k) + 1);
                    }
                    max = (k >= max) ? k : max;
                }
                int[] res = new int[n];
                int l = 0, r = n - 1;
                System.out.println("Max: " + max);
                for (Integer key : map.keySet()) {
                    int freq = map.get(key);
                    System.out.println("l: " + l + " r: " + r);
                    System.out.println("Key: " + key);
                    if (l <= r) {
                        if (key != max) {
                            if (freq == 1) {
                                res[r--] = key;
                            } else if (freq == 2) {
                                res[r--] = key;
                                res[l++] = key;
                            } else {
                                System.out.println("key != max && >=3");
                                l = -1;
                                break;
                            }
                        } else {
                            if (freq == 1) {
                                res[r--] = key;
                            } else {
                                System.out.println("key = max && freq>1");
                                l = -1;
                                break;
                            }
                        }
                    } else {
                        System.out.println("l>r error");
                        l = -1;
                        break;
                    }
                }
                if (l == -1) {
                    System.out.println(-1);
                    continue;
                }
                for (int i = 0; i < res.length; i++) {
                    System.out.print(res[i] + " ");
                }
                System.out.println();
            }
            sc.close();
        } catch (Exception e) {
        }
    }
}
