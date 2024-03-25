import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        } // 최소힙에 다 넣기

        // 최소힙이니까 맨 앞 요소만 K이상인지 확인하면 됨
        // 섞을 음식이 2개 이상이어야 섞을 수 있음
        while(pq.peek() < K && pq.size() > 1){
            int tmp = pq.poll() + (pq.poll() * 2);
            pq.add(tmp);
            answer++;
        }

        // 더 이상 섞을 음식이 없고 스코빌지수가 K이상이 안될 때 -1 return 
        if(pq.size() <= 1 && pq.peek() < K){
            answer = -1;
        }

        return answer;
    }
}