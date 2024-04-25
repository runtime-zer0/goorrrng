import java.util.*;

class Solution {
    private static boolean[][] graph;

    public int solution(int n, int[][] wires) {
        int answer = n;

        // 인접 행렬로 표현하기
        graph = new boolean[n+1][n+1];
        for(int[] w : wires){
            graph[w[0]][w[1]] = true;
            graph[w[1]][w[0]] = true;
        }

        for(int[] w : wires){
            // 완전 탐색으로 하나씩 다 끊기
            graph[w[0]][w[1]] = false;
            graph[w[1]][w[0]] = false;

            // 최솟값 갱신
            answer = Math.min(answer, bfs(n, w[0]));

            graph[w[0]][w[1]] = true;
            graph[w[1]][w[0]] = true;

        }

        return answer;
    }

    // bfs로 끊어진 전력망에 연결된 노드의 수를 구한다. 
    private static int bfs(int n, int x){
        boolean[] visited = new boolean[n+1];
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();
        visited[x] = true;
        q.offer(x);

        while(!q.isEmpty()){
            int tmp = q.poll();

            for(int i = 1; i <= n; i++){
                // 연결 되어있고, 방문하지 않은 노드라면
                if(graph[tmp][i] && ! visited[i]){
                    visited[i] = true;
                    q.offer(i);
                    cnt++;
                }
            }
        }

        // 두 전력망 사이의 개수 차이 반환
        return Math.abs(cnt - (n-cnt));
    }
}
