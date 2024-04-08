import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static int[] dx = {-1,0,1};
    static int answer = 0;
    static boolean[][] v;
    static boolean flag;

    public static boolean DFS(int x, int y){
        v[x][y] = true;
        if(y==m-1) return true;

        for(int i =0; i<3; i++){
            int nx = x+dx[i];
            int ny = y+1;
            if(nx<0||ny<0||nx>=n||ny>=m) continue;
            if(map[nx][ny] == '.' && !v[nx][ny] && DFS(nx,ny)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j]= str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            flag = false;
            if(T.DFS(i,0)) answer++;
        }

        System.out.println(answer);
    }
}