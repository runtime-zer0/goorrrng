package GOORRRNG.김근호.two_pointer._1806_부분합;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int l = 0, r = 0, sum = 0, len = 0, ans = Integer.MAX_VALUE;
        while (true) {
            if (sum >= s) {
                ans = Math.min(ans, len);
                sum -= arr[l++];
                len--;
            } else if(r==n) break;
            else {
                sum += arr[r++];
                len++;
            }
        }
        if(ans == Integer.MAX_VALUE) ans = 0;
        System.out.println(ans);
    }
}
