package GOORRRNG.이다솜.투포인터.부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int lt = 0, rt = 0, sum = 0;

        while (true) {
            if (sum >= s) {
            sum -= arr[lt++];  //부분합이 지정값보다 크거나 같으면 lt를 오른쪽으로 옮기면서 값 빼주기
            } else if (rt == n) {
                break;  //rt가 인덱스 범위를 넘어가면 브레이크
            } else {
                sum += arr[rt++];  //부분합이 지정값보다 작으면 rt를 오른쪽으로 옮기면서 값 더하기
            }

            if (sum >= s) {
                //부분합이 지정값보다 크거나 같으면 answer랑 rt-lt(부분합을 만드는데 필요한 원소의 개수)를 비교해서
                //더 작은 값을 answer로 초기화
                answer = Math.min(answer, rt-lt);
            }
        }
        //answer가 다른 값으로 초기화 되지 않고 초기 설정값 그대로면 0을, 아니면 answer 출력하기
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);

        br.close();
    }
}
