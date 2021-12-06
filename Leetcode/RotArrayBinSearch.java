import java.util.Scanner;

public class RotArrayBinSearch {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] num=new int[n];
            for(int i=0; i<n; i++){
                num[i]=sc.nextInt();
            }
            int targ=sc.nextInt();
            System.out.println(search(num, targ));
        }
    }

    public static int search(int[] nums, int target) {
        int hi=nums.length-1, lo=0, mid;
        while(hi>=lo){
            mid=lo+(hi-lo)/2;
            
            if(nums[mid]==target) return mid;
            
            if(nums[hi]<nums[lo]){
                int m=nums[mid];
                if(m>nums[hi]){
                    if(m>target){
                        if(target>nums[hi]){
                            hi=mid-1;
                        }
                        else if(target<nums[hi]){
                            lo=mid+1;
                        }
                        else if(target==nums[hi]) return hi;
                    }
                    else if(m<target){
                        lo=mid+1;
                    }
                }
                else if(m<nums[hi]){
                    if(m>target){
                        hi=mid-1;
                    }else if(m<target){
                        if(nums[hi]<target) hi=mid-1;
                        else if(nums[hi]>target) lo=mid+1;
                    }
                }
            }else{
                if(target==nums[mid]) return mid;
                else if(target<nums[mid]) hi=mid-1;
                else lo=mid+1;
            }
        }
        return -1;
    }
}
