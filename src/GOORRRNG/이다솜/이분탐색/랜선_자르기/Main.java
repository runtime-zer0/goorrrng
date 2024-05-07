package 랜선_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long x = Long.MIN_VALUE;

        long lt = 1;
        long rt = arr[k-1];

        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            int sum = 0;

            for (int i = 0; i < k; i++) {
                sum += arr[i] / mid;
            }

            if (sum == n) {
                x = Math.max(x, mid);
                lt = mid + 1;
            } else if (sum > n) {
                lt = mid + 1;
                x = Math.max(x, mid);
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(x);
        br.close();
    }
}
