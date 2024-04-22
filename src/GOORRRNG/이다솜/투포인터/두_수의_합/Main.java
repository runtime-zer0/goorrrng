package GOORRRNG.이다솜.투포인터.두_수의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 숫자의 갯수

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  // 배열 오름차순으로 정렬

        int x = Integer.parseInt(br.readLine());  // 두 값을 더해서 구하고자 하는 값

        br.close();
        System.out.println(solution(x, arr));
    }

    private static int solution(int x, int[] arr) {
        int answer = 0;
        int lt = 0, rt = arr.length - 1;

        while (lt < rt) {
            if (arr[lt] + arr[rt] < x) lt++;  //x보다 더한 값이 작을 때는 값을 증가시켜야 하므로
            else if (arr[lt] + arr[rt] > x) rt--;  // x보다 더한 값이 클 때는 값을 감소시켜야 하므로
                // 더한 값이 x와 같으면
            else {
                answer++;
                lt++;
                rt--;
            }
        }
        return answer;
    }
}
