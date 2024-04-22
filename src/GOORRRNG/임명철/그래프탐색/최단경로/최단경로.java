import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight =weight;
    }


    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static int V,E,k,u,v,w;
    static List<Node>[] list;
    static boolean[] visited;
    static int dp[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        k = sc.nextInt();

        list = new List[V+1];
        visited = new boolean[V+1];
        dp = new int[V+1];

        for(int i=1; i<=V; i++) list[i] = new ArrayList<>();
        for(int i=0; i<E; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();

            list[u].add(new Node(v,w));
        }

        Arrays.fill(dp , Integer.MAX_VALUE);
        BFS(k);

        for (int i = 1; i <= V; i++){
            if(dp[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dp[i]);
        }

    }

    public static void BFS(int k){
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.offer(new Node(k,0));
        dp[k] = 0;

        while(!nodes.isEmpty()){
            Node now = nodes.poll();

            if(visited[now.end]) continue;
            visited[now.end] = true;

            for (Node node : list[now.end]) {
                if (dp[node.end] > dp[now.end] + node.weight) {
                    dp[node.end] = dp[now.end] + node.weight;
                    nodes.offer(new Node(node.end, dp[node.end]));
                }
            }

        }

    }
}