package 임시_반장_정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][6];

        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < 6; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, arr));

        br.close();
    }

    private static int solution(int n, int[][] arr) {
        int answer = 1, max = Integer.MIN_VALUE;
        for (int i = 1; i < n+1; i++) {
            int cnt = 0;
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < 6; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }
}
