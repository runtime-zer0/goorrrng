import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 56486486;
    static int N;
    static int sRow,sCol;
    static int Map[][];
    static boolean visited[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};

    static class Point{
        int r,c,d;
        Point(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }

    public static int bfs(int r,int c) {
        int dist = 0;
        int SharkSize = 2;
        int cnt = 0;
        Point set = new Point(r,c,0);

        do { //먹으러가는 최단거리 횟수
            visited = new boolean[N][N];
            Queue<Point> myqueue = new LinkedList<Point>();
            visited[set.r][set.c] = true;
            myqueue.add(new Point(set.r,set.c,0));
            set.d = INF;

            while(!myqueue.isEmpty()) {
                Point curr = myqueue.poll();

                if(curr.d > set.d) break;
                if(Map[curr.r][curr.c] > SharkSize) continue;
                if(Map[curr.r][curr.c] != 0 && Map[curr.r][curr.c] < SharkSize) {
                    if(curr.d < set.d)
                        set = curr;
                    else if(curr.d == set.d) {
                        if(curr.r < set.r)
                            set = curr;
                        else if(curr.r == set.r && curr.c < set.c)
                            set = curr;
                    }
                    continue;
                }

                for(int dir=0; dir<4; dir++) {
                    int nr = curr.r + dx[dir];
                    int nc = curr.c + dy[dir];

                    if(nr < 0 || nc < 0 || nr > N-1 || nc > N-1) continue;
                    if(visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    myqueue.add(new Point(nr,nc,curr.d + 1));
                }
            }

            if(set.d != INF) {
                dist += set.d;
                cnt++;

                if(cnt == SharkSize) {
                    SharkSize++;
                    cnt = 0;
                }
                Map[set.r][set.c] = 0;
            }
        }while(set.d != INF);

        return dist;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        Map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());

                if(Map[i][j] == 9) {
                    sRow = i;
                    sCol = j;
                    Map[i][j] = 0;
                }
            }
        }

        System.out.println(bfs(sRow,sCol));
    }
}
