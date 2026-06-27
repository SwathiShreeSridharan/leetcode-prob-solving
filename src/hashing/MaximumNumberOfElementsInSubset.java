package hashing;

import java.util.HashMap;
import java.util.Scanner;

public class MaximumNumberOfElementsInSubset {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer> freqMap = new HashMap<>();
        for (int j : nums) {
            freqMap.put((long) j, freqMap.getOrDefault((long) j, 0) + 1);
        }
        int maxLength=0;
        for(long num:freqMap.keySet()){
            int len=0;
            long start=num;
            if(start==1){
                int ones=freqMap.get(1L);
                len=ones%2==0?ones-1:ones;
            }
            else{
                while(freqMap.getOrDefault(start,0)>=2){
                    len+=2;
                    start=start*start;
                }
                if(freqMap.getOrDefault(start,0)==1)
                    len+=1;
                else
                    len--;
            }
            maxLength= Math.max(maxLength, len);
        }
        return maxLength;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        MaximumNumberOfElementsInSubset obj=new MaximumNumberOfElementsInSubset();
        System.out.println("Maximum Number of Elements in Subset: "+obj.maximumLength(arr));
    }
}
