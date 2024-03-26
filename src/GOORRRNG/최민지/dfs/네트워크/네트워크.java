class Solution {
  public int solution(int n, int[][] computers) {
      int answer = 0;
      boolean[] visited = new boolean[n]; // 방문 여부
      for(int i = 0; i < n; i++){
          if(!visited[i]){
              dfs(computers, visited, i);
              answer++;
          }
      }
      return answer;
  }

  private static void dfs(int[][] computers, boolean[] visited, int depth){
      visited[depth] = true; // 해당 컴퓨터 방문 여부 true
      // 선택한 컴퓨터에 다른 컴퓨터가 연결되어 있다면 재귀 호출(다른 컴퓨터 방문)
      for(int i = 0; i < computers.length; i++){
          if(computers[depth][i] == 1 && !visited[i]){
              dfs(computers, visited, i);
          }
      } 
  }
}