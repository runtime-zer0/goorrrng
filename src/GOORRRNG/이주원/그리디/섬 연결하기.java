import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        int[] parents = new int[n];
        for(int i = 0; i < parents.length; i++)
            parents[i] = i;
        
        int answer = 0;
        for(int[] cost : costs) {
            if(find(parents, cost[0]) != find(parents, cost[1])) {
                answer += cost[2];
                int p1 = find(parents, cost[0]);
                int p2 = find(parents, cost[1]);
                
                if(p1 < p2)
                    parents[p2] = p1;
                else
                    parents[p1] = p2;
            }
        }
        return answer;
    }
    
    private int find(int[] parents, int target) {
        if(parents[target] == target)
            return target;
        else
            return find(parents, parents[target]);
    }
}