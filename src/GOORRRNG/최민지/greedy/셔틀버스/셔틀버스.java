import java.util.*;

class Solution {

    // 09:00부터 총 n회 t분 간격으로 역에 도착, 하나의 셔틀에는 최대 m 명의 승객이 탈 수 있음.
    // timetable : 크루가 대기열에 도착하는 시각을 모은 배열.
    public String solution(int n, int t, int m, String[] timetable) {

        // 가장 마지막 버스에 빈 자리가 있으면 -> 가장 마지막 버스가 도착하는 시간에 맞춰서 오면 됨
        // 없으면 -> 가장 마지막에 탑승하는 크루원보다 1분 빨리 오면 됨

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable){
            // 계산하기 쉽게 분으로 변환
            String[] arr = time.split(":");
            int hour = Integer.parseInt(arr[0]);
            int min = Integer.parseInt(arr[1]);
            // 우선순위 큐에 저장
            pq.add(hour*60 + min);
        }

        int arrivalTime = 9*60; // 버스 도착 시간
        List<List<Integer>> bus = new ArrayList<>();
        // 버스 운행 횟수만큼 자리 만들기
        for(int i = 0; i < n; i++)
            bus.add(new ArrayList<>());

        int answer = 0;
        for(int i = 0; i < n; i++){
            while(!pq.isEmpty()){
                int crew = pq.poll();
                // 버스 도착 시간보다 일찍 왔고, 자리가 아직 있다면
                if(crew <= arrivalTime && bus.get(i).size() < m){
                    bus.get(i).add(crew); // 버스에 탐   
                    answer = crew - 1; // 마지막 탑승자이면 콘은 그 크루보다 1분 먼저 오면 탈 수 있음
                } else{
                    pq.add(crew); // 다시 큐에 넣고 다음 버스로
                    break;
                }

            }
            arrivalTime += t; // 다음 버스 도착시간 갱신
        }

        // 마지막 버스에 자리가 남으면 그 버스의 출발 시각에 도착하면 됨
        if(bus.get(n-1).size() < m){
            answer = arrivalTime - t;
            // 앞선 for문에서 t를 계속 더해줬기 때문에 마지막 도착시간을 구하려면 다시 빼야 함
        }

        // 다시 00:00 형으로 변환
        return String.format("%02d", answer/60) + ":" + String.format("%02d", answer%60);
    }
}
