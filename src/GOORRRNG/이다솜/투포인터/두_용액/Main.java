package GOORRRNG.이다솜.투포인터.두_용액;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int x : solution(n, arr)) {
            bw.write(String.valueOf(x) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] solution (int n, int[] arr) {
        int[] answer = new int[2];
        int lt = 0;
        int rt = arr.length-1;
        int cv = Integer.MAX_VALUE;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (Math.abs(sum) < Math.abs(cv)) {
                cv = sum;
                answer[0] = arr[lt];
                answer[1] = arr[rt];
            }

            if (sum == 0) {
                break;
            } else if (sum < 0) lt++;
            else rt--;
        }
        return answer;
    }
}
