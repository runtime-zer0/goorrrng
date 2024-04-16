package GOORRRNG.김근호.binary_search._1920_수_찾기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static boolean isExist(int[] arr, int x) {
        int l = 0, r = arr.length-1;
        while(l <= r) {
            int m = (l + r) / 2;
            if (x > arr[m]) l = m + 1;
            else if (x < arr[m]) r = m - 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        // 주어진 배열 입력
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        // 이분 탐색을 위한 정렬
        Arrays.sort(arr);
        // 이분 탐색으로 존재하면 1, 존재하지 않으면 0을 출력
        int m = sc.nextInt();
        while(m-- > 0) {
            int x = sc.nextInt();
            System.out.println(isExist(arr, x) ? 1 : 0);
        }
    }
}