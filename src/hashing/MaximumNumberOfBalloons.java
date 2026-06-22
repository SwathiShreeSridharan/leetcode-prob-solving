package hashing;

import java.util.Scanner;

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] count=new int[26];
        for(int i=0;i<text.length();i++){
            count[text.charAt(i)-'a']++;
        }
        count['o'-'a']/=2;
        count['l'-'a']/=2;
        int c=Integer.MAX_VALUE;
        for(char ch:"balloon".toCharArray()){
            c=Math.min(count[ch-'a'],c);
        }
        return c;
    }

    public static void main(String[] args) {
        MaximumNumberOfBalloons maximumNumberOfBalloons=new MaximumNumberOfBalloons();
        Scanner sc=new Scanner(System.in);
        while(true){
            String s=sc.nextLine();
            if(s.isEmpty()){
                break;
            }
            System.out.println(maximumNumberOfBalloons.maxNumberOfBalloons(s));
        }
    }
}