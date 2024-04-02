import java.util.*;

class Solution {
    // 구간의 끝 지점에 설치할 수록 다른 구간과 겹칠 확률이 늘어난다. 
    public int solution(int[][] routes) {
        int answer = 0; // 설치 카메라 횟수

        // 끝 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

        int camera = Integer.MIN_VALUE; // 카메라 설치 위치

        for(int[] route : routes){
            // 설치한 카메라가 경로에 포함되어 있으면 해당 경로는 이미 단속 카메라를 만났기 때문에 추가 설치 x
            if(camera >= route[0] && camera <= route[1]) continue;
            // 카메라를 만나지 못한 경로라면 그 경로의 끝 지점에 단속 카메라를 설치, 갯수 세기
            camera = route[1];
            answer++;
        }

        return answer;
    }
}
