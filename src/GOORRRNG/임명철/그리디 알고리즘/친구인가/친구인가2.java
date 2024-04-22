import java.util.*;


public class Main {

    static int n,m,k,l;

    static boolean[] visit;
    static int[][] graph;
    public String solution(int v){
        Queue<Integer> q = new LinkedList<>();

        q.add(v);

        while(!q.isEmpty()){
            Integer now = q.poll();
            if(now == l) return "YES";
            for(int i=1; i<=n;i++){
                if(graph[now][i] == 1 && graph[i][now]==1 && !visit[i]){
                    visit[i] = true;
                    q.add(i);
                }
            }
        }

        return "NO";
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        k = sc.nextInt();
        l = sc.nextInt();

        System.out.println(T.solution(k));
    }
}