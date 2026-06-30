package array;

import java.util.Scanner;

public class NumberOfSubstringsContainingAllThreeChars {
    public int numberOfSubstrings(String s) {
        int[] last={-1,-1,-1};
        int count=0;

        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
            if(last[0]!=-1&&last[1]!=-1&&last[2]!=-1){
                count+=Math.min(last[0],Math.min(last[1],last[2]))+1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        NumberOfSubstringsContainingAllThreeChars ob = new NumberOfSubstringsContainingAllThreeChars();
        System.out.println("Number of Substrings: "+ob.numberOfSubstrings(s));
    }
}
