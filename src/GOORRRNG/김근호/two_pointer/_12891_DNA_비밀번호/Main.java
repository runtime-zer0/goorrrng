package GOORRRNG.김근호.two_pointer._12891_DNA_비밀번호;

import java.util.Scanner;

public class Main {
    static int charToIndex(char c) {
        if (c == 'A') return 0;
        else if (c == 'C') return 1;
        else if (c == 'G') return 2;
        else if (c == 'T') return 3;
        return -1;
    }

    static boolean isValid(int[] cntArr, int[] minimumCntArr) {
        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] < minimumCntArr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int p = sc.nextInt();
        char[] charArr = sc.next().toCharArray();
        int[] minimumCntArr = new int[4];
        for (int i = 0; i < 4; i++) {
            minimumCntArr[i] = sc.nextInt();
        }

        int[] cntArr = new int[4];
        for(int i=0; i<p; i++) {
            cntArr[charToIndex(charArr[i])]++;
        }

        int l = 0, r = p, ans = 0;
        while (true) {
            if(isValid(cntArr, minimumCntArr)) ans++;
            if(r == s) break;
            cntArr[charToIndex(charArr[l++])]--;
            cntArr[charToIndex(charArr[r++])]++;
        }

        System.out.println(ans);
    }
}
