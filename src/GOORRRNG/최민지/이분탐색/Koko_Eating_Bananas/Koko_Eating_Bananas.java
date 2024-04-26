class Solution {
  public int minEatingSpeed(int[] piles, int h) {

    // 1 ~ 제일 큰 더미 이분 탐색 하면서
    // h시간 안에 먹을 수 있는 지 체크 
    // 먹을 수 있으면 end 조정 
    // 못 먹으면 start 조정

    int start = 1;
    int end = 0;

    // 제일 큰 더미 찾기
    for(int pile : piles){
      end = Math.max(end, pile);
    }

    int mid;

    // 이분 탐색
    while(start < end){
      mid  = (start + end) / 2;
      if(check(mid, piles, h)) {
        end = mid;
      }
      else start = mid + 1;
    }

    return start;
  }

  // h 안에 먹을 수 있는 지 검사
  private boolean check(int k, int[] piles, int h){
    int hours = 0;
    
    for(int pile : piles){
      int time = pile / k;
      hours += time;
      if(pile % k != 0) hours++;
    }

    return hours <= h;
  }
}