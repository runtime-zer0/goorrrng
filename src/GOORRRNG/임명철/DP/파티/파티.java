import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Info implements Comparable<Info>{
    int node;
    int dist;

    public Info(int node, int dist){
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Info o) {
        return dist - o.dist;
    }
}

public class Main {
    static int n,m,x;
    static ArrayList<ArrayList<Info>> graph, reverse_graph;
    static boolean[][] check, check2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverse_graph = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
            reverse_graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph.get(prev).add(new Info(next, value));
            reverse_graph.get(next).add(new Info(prev, value));
        }

        int[] dist1 = dijkstra(graph);
        int[] dist2 = dijkstra(reverse_graph);

        //1부터 N까지 각각의 마을에 살고있는 한명으로부터 x까지의 거리를 구해서 각각의 값들의 최댓값을 출력한다.
        int answer = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            answer = Math.max(answer, dist1[i] + dist2[i]);
        }

        System.out.println(answer);
    }

    public static int[] dijkstra(ArrayList<ArrayList<Info>> g){
        PriorityQueue<Info> pQ = new PriorityQueue<>();
        pQ.offer(new Info(x,0));

        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        while(!pQ.isEmpty()){
            Info curr = pQ.poll();
            int node = curr.node;

            for (Info info : g.get(node)) {
                if(!check[info.node] && dist[info.node] > dist[node] + info.dist){
                    dist[info.node] = dist[node] + info.dist;
                    pQ.add(new Info(info.node, dist[info.node]));
                }
            }
        }
        return dist;
    }
}