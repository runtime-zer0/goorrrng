package 이분탐색.숫자_카드2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int [] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            sb.append(findUpper(cards, num) - findLower(cards, num));
            sb.append(' ');
        }

        bw.write(String.valueOf(sb));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findLower (int[] arr, int num) {
        int lt = 0;
        int rt = arr.length;

        while (lt < rt) {
            int mid = (lt+rt) / 2;

            if (num <= arr[mid]) rt = mid;
            else lt = mid + 1;
        }
        return lt;
    }

    public static int findUpper (int[] arr, int num) {
        int lt = 0;
        int rt = arr.length;

        while (lt < rt) {
            int mid = (lt+rt) / 2;

            if (num >= arr[mid]) lt = mid + 1;
            else rt = mid;
        }
        return lt;
    }
}
