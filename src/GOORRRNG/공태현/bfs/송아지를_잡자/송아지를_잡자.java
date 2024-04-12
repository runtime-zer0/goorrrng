package GOORRRNG.공태현.bfs.송아지를_잡자;

import java.util.LinkedList;
import java.util.Queue;

public class 송아지를_잡자 {

    static boolean[][] visited;
    static Queue<Integer> queue;
    public static int BFS(int s, int e) {
        queue = new LinkedList<>();
        visited[0][s] = true;
        queue.offer(s);
        int level = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            level++;
            for(int i = 0; i < len; i++){
                int cur = queue.poll();
                for (int nx : new int[]{cur - 1, cur + 1, cur * 2}) {
                    if (nx >= 0 && nx <= 200000 && !visited[level % 2][nx]) {
                        visited[level % 2][nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            e = e + level;
            if(e > 200000){
                return -1;
            }
            if (visited[level % 2][e]) {
                return level;
            }
        }
        return -1;
    }


    public static int solution(int s, int e){
        visited = new boolean[2][200001];
        return BFS(s, e);
    }

}
