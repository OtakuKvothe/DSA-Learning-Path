//https://leetcode.com/problems/previous-permutation-with-one-swap

public class PrevPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] arr) {
        if(arr.length <= 1) return arr;
        int i=arr.length-2;
        while(i>=0&&arr[i+1]>=arr[i]) i--;
        if(i>=0){
            int pos=i+1;
            for(int j = pos+1; j<arr.length; j++){
                if(arr[pos]<arr[j] && arr[j]<arr[i]) pos=j;
            }
            int t=arr[i];
            arr[i]=arr[pos];
            arr[pos]=t;
        }
        return arr;
    }
}
