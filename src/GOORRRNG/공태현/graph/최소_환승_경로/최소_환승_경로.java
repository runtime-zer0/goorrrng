package GOORRRNG.공태현.graph.최소_환승_경로;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 최소_환승_경로 {

    public static int solution(int[][] routes, int s, int e){
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;

        for(int i = 0; i < n; i++){
            for(int route : routes[i]){
                graph.putIfAbsent(route, new HashSet<>());
                graph.get(route).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(s);

        int level = 0;
        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i = 0; i < len; i++){
                int curStation = queue.poll();

                for(int line : graph.get(curStation)){
                    if (visited[line]) {
                        continue;
                    }
                    visited[line] = true;
                    for(int stop : routes[line]){
                        if (stop == e) {
                            return level;
                        }
                        queue.offer(stop);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
