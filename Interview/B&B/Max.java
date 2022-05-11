public class Max {
    public static void main(String[] args) {
        int[] arr = { 7, 4, 8, 2, 3, 6, 1 };
        int max = Math.max(arr[0], arr[1]), max2 = Math.min(arr[0], arr[1]), max3 = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > max) {
                max3 = max2;
                max2 = max;
                max = arr[i];
            } else if (arr[i] > max2) {
                max3 = max2;
                max2 = arr[i];
            } else if (arr[i] > max3) {
                max3 = arr[i];
            }
        }
        System.out.println("Max: " + max + " 2nd max: " + max2 + " max3: " + max3);
    }
}
