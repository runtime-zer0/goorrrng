class Solution {
  public int solution(String name) {
      // 맨처음엔 A로 이루어져 있다. A가 아닌 문자는 상하 이동
      // 아스키코드 이용 : A에서 시작한다면 ch - A, Z부터 시작하면 Z - ch + 1 

      // 좌우 이동 방법 3가지
      // 1. 이동 방향의 최댓값은 한 방향으로만 가는 경우 : name.length() - 1
      // 2. 오른쪽으로 갔다가 왼쪽으로 가는 경우 ex) BBAAAAAYYY 
      // 3. 왼쪽으로 갔다가 오른쪽으로 가는 경우 ex) CCCAAAAAAY

      int answer = 0;
      int min = name.length() - 1; // 좌우 이동 1번 경우
      int index; // 다음 값 확인 시에 사용

      for(int i = 0; i < name.length(); i++){
          // 상하 이동 최솟값 구하기
          answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

          index = i + 1;

          // 연속되는 A 갯수 확인
          while(index < name.length() && name.charAt(index) == 'A'){
              index++;
          }

          // 좌우 이동 2번 경우
          min = Math.min(min, i * 2 + name.length() - index);

          // 좌우 이동 3번 경우
          min = Math.min(min, (name.length() - index) * 2 + i);
      }

      return answer + min;
  }
}
