/*
    Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
*/

public class RainWater {
    static long trappingWater(int[] arr, int n){
        long res = 0;
        int[] arlt = new int[n];
        int[] arrt = new int[n];

        arlt[0] = arr[0];
        for(int i=1; i<n; i++){
            arlt[i]=Math.max(arlt[i-1], arr[i]);
        }

        arrt[n-1]=arr[n-1];
        for(int i=n-2; i>0; i++){
            arrt[i]=Math.max(arr[i], arrt[i+1]);
        }

        for(int i=0; i<n; i++){
            res+=Math.min(arrt[i],arlt[i])-arr[i];
        }
        return res;
    }
}
