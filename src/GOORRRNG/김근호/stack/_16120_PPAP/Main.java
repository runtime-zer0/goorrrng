package GOORRRNG.김근호.stack._16120_PPAP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] inputArr = sc.next().toCharArray();
        char[] answer = new char[inputArr.length];
        int len = 0;
        for (char c : inputArr) {
            answer[len++] = c;
            if ( len >= 4 && answer[len-4] == 'P' && answer[len-3] == 'P'
                    && answer[len-2] == 'A' && answer[len-1] == 'P') len -= 3;

        }
        System.out.println(len == 1 && answer[0]=='P' ? "PPAP" : "NP");
    }
}

