package GOORRRNG.김근호.binary_search._1654_랜선_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long binarySearch(int[] arr, int k, int n) {
        long l = 1, r = Integer.MAX_VALUE, answer = 0;
        while (l <= r) {
            long m = (l + r) / 2;
            int cnt = 0;
            for(int i=0; i<k; i++) {
                cnt += arr[i] / m;
            }
            if(cnt >= n) {
                answer = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(binarySearch(arr, k, n));
    }
}
