import java.util.*;

class Solution {
    private static List<Integer>[] graph; // 인접 리스트 : 각 지점에서 연결된 다른 지점들의 리스트를 저장함
    private static int[] dis; // 거리 저장
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length]; // 정답 배열

        // 인접 리스트 초기화
        graph = new List[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList();
        }

        // 인접 행렬 정보 입력
        for(int[] road : roads){
            // 양방향
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        dis = new int[n+1];
        Arrays.fill(dis, -1);
        // 모든 간선의 가중치가 1이고, destination은 1개이다.
        // 따라서 bfs의 결과가 곧 최단거리임.
        // 도착지로부터 bfs 탐색하여 각 부대원이 있는 위치까지 최단 거리를 구할 수 있다.
        bfs(destination);

        // 정답 배열에 저장해 반환
        for(int i = 0; i < sources.length; i++){
            answer[i] = dis[sources[i]];
        }

        return answer;
    }

    // 시작 지점부터 각 지점까지 최단 거리 계산
    private void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dis[start] = 0; // 부대

        while(!q.isEmpty()){
            int tmp = q.poll();

            // 연결된 노드들 다 검사
            for(int i = 0; i < graph[tmp].size(); i++){
                int next = graph[tmp].get(i); // 다음노드 지정
                if(dis[next] == -1){ // 최단 거리가 아직 계산되지 않은 경우만
                    dis[next] = dis[tmp] + 1; // 거리 저장
                    q.add(next);
                }
            }
        }

    }
}
