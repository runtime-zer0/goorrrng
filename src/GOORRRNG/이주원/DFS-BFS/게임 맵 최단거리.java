import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        final int[] dx = {0, 1, 0, -1};
        final int[] dy = {1, 0, -1, 0};
        
        LinkedList<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0});
        maps[0][0] = 1;
        
        while(!queue.isEmpty()) {
            
            int[] p = queue.poll();
            
            if(p[0] == maps.length - 1 && p[1] == maps[0].length - 1)
                return maps[p[0]][p[1]];
            
            for(int i = 0; i < dx.length; i++) {
                int x = dx[i] + p[1];
                int y = dy[i] + p[0];
                
                if(x > -1
                  && x < maps[0].length
                  && y > -1
                  && y < maps.length
                  && maps[y][x] == 1
                  && x+y != 0){
                    
                    queue.offer(new int[]{y, x});
                    maps[y][x] = maps[p[0]][p[1]] + 1;
                }
            }
        }
        return -1;
    }
}