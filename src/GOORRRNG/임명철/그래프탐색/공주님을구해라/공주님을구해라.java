import java.util.*;

class Point{
    int x,y,d, hasSword;

    public Point(int x,int y,int d,int s){
        this.x=x;
        this.y=y;
        this.d=d;
        this.hasSword =s;
    }
}

public class Main {
    static int n,m,k;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx ={0,0,1,-1};
    static int[] dy ={1,-1,0,0};
    static int answer =-1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,0,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Point curr = q.poll();

            if(curr.d > k) continue;
            if(curr.x == n-1 && curr.y == m-1) {
                answer = curr.d;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = curr.x+dx[i];
                int ny = curr.y+dy[i];
                int hasSword = curr.hasSword;

                if(nx < 0 || ny < 0 || nx > n-1 || ny > m-1) continue;

                if(hasSword == 0){
                    if(visited[nx][ny][0] || map[nx][ny] == 1) continue;
                    if(map[nx][ny] == 2) hasSword++;
                }else{
                    if(visited[nx][ny][1]) continue;
                }
                visited[nx][ny][hasSword] = true;
                q.add(new Point(nx,ny,curr.d+1, hasSword));

            }
        }

        if(answer < 0) System.out.println("Fail");
        else System.out.println(answer);
    }

}