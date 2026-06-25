package Array;

import java.util.Scanner;

public class CountSubarraysWithMajorityElement {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j]==target?1:-1;
                if(sum>0)count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int[]  arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the target element");
        int target=sc.nextInt();
        CountSubarraysWithMajorityElement obj=new CountSubarraysWithMajorityElement();
        System.out.println(obj.countMajoritySubarrays(arr,target));
    }
}
