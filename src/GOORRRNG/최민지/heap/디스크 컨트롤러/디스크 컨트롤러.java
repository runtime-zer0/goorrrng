import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        // Shortest Job First (SJF) 스케줄링 알고리즘
        // 접근 방법 : 현재 수행되는 작업이 끝나는 시점에서 대기하는 애들 중 요청시간이 제일 짧은 작업을 골라야 한다. 
        
        int answer = 0;
        
        // jobs 배열을 요청 시간의 오름차순으로 정렬
        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
        
        // 소요시간의 오름차순으로 정렬되도록
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int index = 0;
        int count = 0; // 요청 갯수
        int total = 0;
        int end = 0; // 현재 작업 중인 job이 끝나는 시간
        
        while(count < jobs.length){
            while(index < jobs.length && jobs[index][0] <= end){
                pq.add(jobs[index++]); 
                //현재 작업 중인 job이 끝나는 시간 전에 요청된 작업들을 우선순위 큐에 추가
            } 
            
            if(pq.isEmpty()){
                end = jobs[index][0]; // 큐가 비어있으면 현재 작업이 끝나는 시간을 다음 요청이 들어온 시간으로 업데이트
            } else{
                int[] tmp = pq.poll(); // 소요 시간이 제일 적게 걸리는 애를 골라서
                total += tmp[1] + end - tmp[0];
                // 요청부터 종료까지 걸린 시간 = 소요 시간 + 현재 작업 중인 job이 끝나는 시간 - 요청 도착 시간
                end += tmp[1]; // 종료시간 갱신
                count++;
            }
        }
        
        // 평균 계산
        answer = total/jobs.length;
        
        return answer;
    }
}
