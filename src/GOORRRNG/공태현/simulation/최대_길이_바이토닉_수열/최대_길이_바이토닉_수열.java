package GOORRRNG.공태현.simulation.최대_길이_바이토닉_수열;

import java.util.ArrayList;
import java.util.List;

public class 최대_길이_바이토닉_수열 {

    static int solution(int[] nums) {
        int n = nums.length;
        int answer = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        // 봉우리(peek) 원소의 인덱스를 탐색
        for (int i = 1; i < n-1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                list.add(i);
            }
        }
        // 봉우리 인덱스 만을 기준으로 탐색 시작
        for (int idx : list) {
            int cnt = 1;
            int lt = idx;
            int rt = idx;
            // 봉우리(peek) 기준 왼쪽 방향으로 탐색
            // lt가 0보다 크고 현재 lt 가 가리키고있는 원소가 lt - 1이 가리키는 원소보다 큰지 확인
            while (lt > 0 && nums[lt - 1] < nums[lt]) {
                // 크다면 바이토닉수열 원소를 찾은것이므로 cnt 1 증가
                cnt++;
                // 다음 탐색을 위해 lt값 1 감소
                lt--;
            }
            // 봉우리(peek) 기준 오른쪽 방향으로 탐색
            // rt가 n-1 보다 크고 현재 rt가 가리키는 원소가 rt+1이 가리키고있는 원소보다 큰지 확인
            while (rt < n-1 && nums[rt] > nums[rt+1]) {
                // 크다면 바이토닉수열 원소를 찾은것이므로 cnt 1 증가
                cnt++;
                // 다음 탐색을 위해 rt값 1 증가
                rt++;
            }
            // 최대 길이값 계산
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
