package GOORRRNG.김근호.stack._9012_괄호;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            char[] charArray = sc.next().toCharArray();
            int cnt = 0;
            for (char c : charArray) {
                if (c == '(') cnt++;
                else cnt--;
                if (cnt < 0) break;
            }
            if(cnt != 0) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
