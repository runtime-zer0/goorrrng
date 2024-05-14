package 프린터_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];

            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[j] = tmp;
                queue.add(j);
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                boolean check = false;
                int before = queue.poll();

                for (int num : arr) {
                    if (arr[before] < num) {
                        queue.add(before);
                        check = true;
                        break;
                    }
                }

                if (!check) {
                    cnt++;
                    arr[before] = 0;
                    if (before == m) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }
}
