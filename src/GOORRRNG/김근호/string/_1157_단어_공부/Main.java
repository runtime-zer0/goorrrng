package GOORRRNG.김근호.string._1157_단어_공부;

import java.util.Scanner;

public class Main {
    static int[] countAlpha(String str) {
        int[] arr = new int[26];
        for(int i=0; i<str.length(); i++) {
            arr[str.charAt(i)-'A']++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();
        int[] arr = countAlpha(str);

        int maxCnt = 0;
        char maxAlp = '?';
        for(int i=0; i<26; i++) {
            if(arr[i] > maxCnt) {
                maxCnt = arr[i];
                maxAlp = (char)('A'+i);
            } else if (arr[i] == maxCnt) {
                maxAlp = '?';
            }
        }
        System.out.println(maxAlp);
    }
}
