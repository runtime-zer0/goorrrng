class Solution {
  public int solution(int n, int[] stations, int w) {
      int answer = 0;
      int sectionLen;

      // 기지국의 전파 전달 길이 : 2W + 1
      // 빈 구간들의 길이를 계산하고, 2W + 1로 나누어 올림 처리하면 각 빈 구간에 설치할 기지국 개수를 구할 수 있다.

      for(int i = 0; i <= stations.length; i++){
          if(i == 0){ // 구간 시작 부터 ~ 첫 번째 설치 되어 있는 기지국 구간길이
              sectionLen = stations[i] - 1 - w;
          } else if(i == stations.length){ // 마지막 설치되어 있는 기지국 구간 부터 ~ 구간 마지막까지 길이
              sectionLen = n - stations[i - 1] - w;
          } else { // 기지국들 사이의 구간 길이
              sectionLen = stations[i] - stations[i - 1] - 2 * w - 1;
          }

          if (sectionLen >= 0){
              answer += sectionLen / (2 * w + 1);
              if(sectionLen % (2 * w + 1) != 0){ // 나누어 떨어지지 않는다면 하나 더 설치
                  answer++;

              }
          }
      }

      return answer;
  }
}
