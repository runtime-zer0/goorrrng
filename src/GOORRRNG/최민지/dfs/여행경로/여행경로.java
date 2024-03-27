import java.util.*;

class Solution {

    private static List<String> results;
    private static boolean[] visited;

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        // ICN 공항부터 시작해서 모든 티켓을 이용해 모든 공항을 방문하는 방법을 찾는 문제
        // 접근 방법 : 갈 수 있는 모든 경로를 탐색하여 알파벳 순서가 앞서는 경로를 반환

        // 가능한 경로가 여러 개일 경우를 위해 경로들을 저장할 리스트
        results = new ArrayList<>();
        // 방문 확인 배열
        visited = new boolean[tickets.length];
        int depth = 0;

        dfs(depth, "ICN", "ICN", tickets); // depth, 현재 위치, 경로, 티켓 배열

        Collections.sort(results); // 경로들 오름차순 정렬
        answer = results.get(0).split(" "); // 정렬된 첫 번째 경로를 정답으로 

        return answer;
    }

    private static void dfs(int depth, String now, String result, String[][] tickets){
        // 종료 조건
        if(depth == tickets.length){
            results.add(result); // 경로들을 저장하는 list에 경로 저장
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            // 해당 티켓이 사용 됐는지, 현재 위치랑 출발지가 같은지
            if(!visited[i] && now.equals(tickets[i][0])){
                visited[i] = true;
                dfs(depth+1, tickets[i][1], result+" " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
