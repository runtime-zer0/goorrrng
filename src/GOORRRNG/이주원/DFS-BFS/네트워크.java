class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int[][] computers, int no, boolean[] visited) {
        
        int[] computer = computers[no];
        visited[no] = true;
        
        for(int i = 0; i < computer.length; i++) {
            if(!visited[i] && computer[i] == 1)
                dfs(computers, i, visited);
        } 
    }
}