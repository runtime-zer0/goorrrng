import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, Q;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	static int[] visit;

	static List<Q> QList= new ArrayList<>();

	static class Node {
		int vertex;
		int USADO;

		public Node(int vertex, int USADO) {
			this.vertex = vertex;
			this.USADO = USADO;
		}
	}

	static class Q {
		int K;
		int V;

		public Q(int K, int V) {
			this.K = K;
			this.V = V;
		}
	}

	public static void DFS(int v, int min) {

		for (Node node : graph.get(v)) {
			if (visit[node.vertex] == 0) {
				int currentMin = Math.min(min, node.USADO);
				visit[node.vertex] = currentMin;
				DFS(node.vertex, currentMin);
			}
		}
	}

	public static String solution() {
		StringBuilder sb = new StringBuilder();
		for(Q q:QList){
			visit = new int[N + 1];
			visit[q.V]=-1;
			DFS(q.V,Integer.MAX_VALUE);
			int count=0;
			for (int i = 1; i < visit.length; i++) {
				if(visit[i]>= q.K){
					count++;
				}
			}
			sb.append(count);
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			graph.get(v1).add(new Node(v2, r));
			graph.get(v2).add(new Node(v1, r));
		}
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			QList.add(new Q(k, v));
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(solution());

	}
}
