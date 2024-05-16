import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < enemy.length; i++){
            if(k > 0){
                pq.offer(enemy[i]);
                k--;
            }   // 처음 무적권의 갯수만큼 pq에 넣기
            else { // 무적권을 다 쓰면
                int enemys = enemy[i]; // 막을 적의 수
                if(pq.peek() < enemy[i]) {
                    // pq에 있는 값이 더 작다면? -> 해당 단계에 무적권을 쓰는게 이득이다. pq에 있는 단계는 그냥 막기.
                    enemys = pq.poll();
                    pq.offer(enemy[i]);
                } 

                // 남은 병사 수가 더 많은 지 비교
                if(n >= enemys){
                    n -= enemys; // 병사 수 빼기
                } else  break;
            }
            answer++ ;
        }

        return answer;
    }
}
