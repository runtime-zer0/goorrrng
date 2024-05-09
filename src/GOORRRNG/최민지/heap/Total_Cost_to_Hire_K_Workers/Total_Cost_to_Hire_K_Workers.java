import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        int start = 0;
        int end = costs.length-1;
        long answer = 0;

        // pq 2개 준비
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for(int i = 0; i < k; i++){
          // 후보 수 만큼 앞에서부터 pq에 넣기
          while(pq1.size() < candidates && start <= end)  {
            pq1.offer(costs[start++]);
          }
          // 후보 수 만큼 뒤에서부터 pq에 넣기
          while(pq2.size() < candidates && start <= end)  {
            pq2.offer(costs[end--]);
          }

          // 최솟값 얻기
          int min1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
          int min2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

          // 인덱스가 더 작은 요소가 더 높은 우선순위
          if(min1 <= min2){
            answer += min1;
            pq1.poll();
          } else {
            answer += min2;
            pq2.poll();
          }
        }

        return answer;
    }
}
