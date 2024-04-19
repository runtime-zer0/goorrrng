package GOORRRNG.공태현.graph.최소_비행료;

import java.util.*;

public class 최소_비행료 {

    static int[] costs;
    static List<ArrayList<int[]>> graph;
    public static int solution(int n, int[][] flights, int s, int e, int k){
        graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int[] costs = new int[n];
        Arrays.fill(costs, 1000000000);
        for(int[] flight : flights){
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, 0});
        costs[s] = 0;

        int level = 0;
        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i = 0; i < len; i++){
                int[] cur = queue.poll();
                int curNode = cur[0];
                int curCost = cur[1];

                for(int[] x : graph.get(curNode)){
                    int nextNode = x[0];
                    int nextCost = x[1];

                    if(curCost + nextCost < costs[nextNode]){
                        costs[nextNode] = curCost + nextCost;
                        queue.offer(new int[]{nextNode, costs[nextNode]});
                    }
                }
            }

            level++;
            if (level > k) {
                break;
            }
        }

        if (costs[e] == 1000000000) {
            return -1;
        } else {
            return costs[e];
        }
    }
}