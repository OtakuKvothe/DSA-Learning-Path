import java.util.Scanner;

public class IntegerToWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(numberToWords(n));
        }
    }

    public static String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String[] suff = { "", "Thousand", "Million", "Billion" };
        String[] digs = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
        String[] teens = { "", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen" };
        String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        String ten = "Ten";
        String out = new String();
        String res = new String();
        int x = 0;
        while (num > 0) {
            int n = num % 1000;
            num = num / 1000;
            if (n != 0) {
                int d = n % 10;
                n /= 10;

                int t = n % 10;
                n /= 10;

                int h = n % 10;
                n /= 10;

                if (t == 1) {
                    if (d == 0) {
                        res = ten + " " + res;
                    } else {
                        res = teens[d] + " " + res;
                    }
                } else {
                    res = (tens[t].equals("") ? "" : (tens[t] + " ")) + (digs[d].equals("") ? "" : (digs[d] + " "))
                            + res;
                }
                res = (digs[h].equals("") ? "" : (digs[h] + " Hundred ")) + res;

                out = res + (suff[x].equals("") ? "" : (suff[x] + " ")) + out;
            }
            x++;
            res = "";
        }

        return out.trim();
    }
}
