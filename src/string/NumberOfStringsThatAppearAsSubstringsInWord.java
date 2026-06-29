package string;

import java.util.Scanner;

public class NumberOfStringsThatAppearAsSubstringsInWord {
    public int numOfStrings(String[] patterns, String word) {
        int count=0;
        for(String str:patterns){
            if(word.contains(str))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the string array");
        int length=sc.nextInt();
        sc.nextLine();
        String[] patterns=new String[length];
        System.out.println("Enter the string");
        for(int i=0;i<length;i++)
            patterns[i]=sc.next();
        System.out.println("Enter the word");
        String word=sc.next();
        NumberOfStringsThatAppearAsSubstringsInWord  ob=new NumberOfStringsThatAppearAsSubstringsInWord();
        int res=ob.numOfStrings(patterns,word);
        System.out.println("No. of Strings that appears as substring in word: "+res);
    }
}
