package GOORRRNG.김근호.greedy_algorithm.다익스트라_알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;
    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }

    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public int solution(int v){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dis[v] = 0;
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int nowVex = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost > dis[nowVex]) continue;
            for(Edge o : graph.get(nowVex)){
                if(dis[o.vex]>nowCost+o.cost){
                    dis[o.vex] = nowCost+o.cost;
                    pq.offer(new Edge(o.vex, nowCost + o.cost));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        main.solution(1);
        for(int i=2; i<=n; i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}