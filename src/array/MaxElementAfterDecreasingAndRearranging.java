package array;

import java.util.Arrays;
import java.util.Scanner;

public class MaxElementAfterDecreasingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int maxElement=1;
        if(arr[0]!=1){
            arr[0]=1;
        }
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])>1){
                maxElement++;
                arr[i]=maxElement;
            }
            else{
                maxElement=Math.max(maxElement,arr[i]);
            }
        }
        return maxElement;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n=sc.nextInt();
        System.out.println("Enter the elements in the array");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        MaxElementAfterDecreasingAndRearranging  obj=new MaxElementAfterDecreasingAndRearranging();
        int res=obj.maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println("Max Element: "+res);
    }
}
