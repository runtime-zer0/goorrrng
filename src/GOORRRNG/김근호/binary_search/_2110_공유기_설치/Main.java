package GOORRRNG.김근호.binary_search._2110_공유기_설치;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int calculateCount(int[] arr, int distance) {
        int px = arr[0];
        int cnt = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] - px >= distance) {
                px = arr[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // 1. 공유기 사이의 거리 탐색 범위를 정한다.
        int l = 0, r = arr[n-1] - arr[0], ans = -1; // 끝 - 처음
        while (l<=r) {
            // 2. 인접한 공유기에 대해 거리를 지키면서
            // 공유기를 설치할 수 있다면 거리를 늘리고
            // 설치할 수 없다면 거리를 좁힌다.
            int m = (l + r) / 2;
            if (calculateCount(arr, m) >= c) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        // 3. 공유기 사이의 최대 거리를 출력한다.
        System.out.println(ans);
    }
}
