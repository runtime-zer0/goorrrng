package GOORRRNG.김근호.two_pointer._2470_두_용액;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int l = 0, r = n - 1;
        int leftIdx = -1;
        int rightIdx = -1;
        int optimalAbs = Integer.MAX_VALUE;
        while(l<r) {
            int sum = arr[l] + arr[r];
            int abs = Math.abs(sum);
            if (optimalAbs > abs) {
                optimalAbs = abs;
                leftIdx = l;
                rightIdx = r;
            }
            if (sum > 0) r--;
            else l++;
        }
        System.out.println(arr[leftIdx] + " " + arr[rightIdx]);
    }
}