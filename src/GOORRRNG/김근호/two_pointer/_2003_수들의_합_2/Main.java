package GOORRRNG.김근호.two_pointer._2003_수들의_합_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int l = 0, r = 0, sum = 0, ans = 0;
        while (true) {
            if (sum >= m) sum -= arr[l++];
            else if (r == n) break;
            else sum += arr[r++];

            if (sum == m) ans++;
        }
        System.out.println(ans);
    }
}
