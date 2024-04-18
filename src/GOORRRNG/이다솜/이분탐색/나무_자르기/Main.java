package 나무_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] trees;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        trees = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int start = 0;
        int end = Arrays.stream(trees).max().getAsInt();
        int mid = (start + end) / 2;
        Long result = solution(mid);

        while (start <= end) {
            if (result < m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            mid = (start + end) / 2;
            result = solution(mid);
        }

        System.out.println(mid);
    }

    public static Long solution(int h) {
        Long result = 0L;
        for (int tree : trees) {
            result += (Math.max((tree - h), 0));
        }
        return result;
    }
}
