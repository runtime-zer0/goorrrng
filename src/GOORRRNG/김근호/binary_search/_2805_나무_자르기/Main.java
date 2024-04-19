package GOORRRNG.김근호.binary_search._2805_나무_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int binarySearch(int[] arr, int n, int m) {
        // 1. 절단기 높이의 탐색 범위를 정한다.
        int l = 0, r = 1000000000;
        int answer = 0;
        // 2. 적어도 m만큼 나무를 가져갈 수 있게 절단기 높이를 조절한다.
        while (l <= r) {
            long sum = 0;
            int mid = (l + r) / 2;
            for(int i=0; i<n; i++) {
                if(arr[i] > mid)
                    sum += arr[i] - mid;
            }
            // 3. 절단기 높이 중 최대값을 출력한다.
            if(sum >= m) {
                answer = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(arr, n, m));;
    }
}
