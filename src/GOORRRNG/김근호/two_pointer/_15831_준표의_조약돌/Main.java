package GOORRRNG.김근호.two_pointer._15831_준표의_조약돌;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int black = sc.nextInt();
        int white = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        int r = 0, countBlack = 0, countWhite=0, ans = 0;
        for (int l = 0; l < n; l++) {
            while (r < n) {
                if (arr[r] == 'B' && countBlack == black) break;
                if (arr[r++] == 'W') countWhite++;
                else countBlack++;
            }
            if (countWhite >= white) ans = Math.max(ans, r-l);
            if (arr[l] == 'B') countWhite--;
            else countBlack--;
        }
        System.out.println(ans);
    }
}
