import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Point{
        int row, col, dist;
        Point(int r, int c, int d){
            row = r;
            col = c;
            dist = d;
        }
    }

    public static int solution(int n, int m , int[][] map) {
        boolean[][] visited = new boolean[n+1][m+1];
        Queue<Point> myqueue= new LinkedList<>();
        visited[0][0] = true;
        myqueue.add(new Point(0,0,1));
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!myqueue.isEmpty()) {
            Point now = myqueue.remove();

            if(now.row == n && now.col == m) {
                return now.dist;
            }

            for(int dir=0; dir<4; dir++) {
                int nr = now.row + dx[dir];
                int nc = now.col + dy[dir];
                int dist = now.dist;

                if(nr < 0 || nc < 0 || nr > n || nc > m) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                myqueue.add(new Point(nr,nc, dist+1));
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];

        for(int i=0; i<n; i++) {
            String str = sc.next();
            char[] ch = str.toCharArray();
            for(int j=0; j<m; j++) {
                map[i][j] = ch[j] - 48;
            }
        }


        System.out.println(solution(n-1,m-1,map));
    }
}
