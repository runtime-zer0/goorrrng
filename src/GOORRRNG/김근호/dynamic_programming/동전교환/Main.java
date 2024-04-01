package GOORRRNG.김근호.dynamic_programming.동전교환;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] dy;
    public int solution (int[] arr) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=arr[i]; j<=m; j++) {
                dy[j] = Math.min(dy[j], dy[j - arr[i]] + 1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i]=scanner.nextInt();
        m = scanner.nextInt();
        dy = new int[m+1];
        System.out.print(main.solution(arr));
    }
}