import java.util.*;
import java.io.*;

class Pos {
	int r;
	int c;
	
	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Main {

	static int n;
	static int m;
	static int[][] map;
	static ArrayList<Pos> house = new ArrayList<>();
	static ArrayList<Pos> chicken = new ArrayList<>();
	static boolean[] visited; // 치킨집 방문 여부
	static int minCityChickenDist = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception
	{
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					// 집
					house.add(new Pos(i, j));
				} else if(map[i][j] == 2) {
					// 치킨 집
					chicken.add(new Pos(i, j));
				}
			}
		}
		
		visited = new boolean[chicken.size()];
		
		dfs(0, 0);
		
		System.out.println(minCityChickenDist);
		br.close();
	}
	
	private static void dfs(int depth, int idx) {
		// 종료 조건
		if(depth == m) {
			int cityChickenDist = 0; // 도시의 치킨 거리
			for(int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0; j < chicken.size(); j++) {
					if(visited[j]) {
						// 치킨집이랑 각 집들 간의 최소 거리를 구한다. 
						int dist = Math.abs(chicken.get(j).r - house.get(i).r) + 
								Math.abs(chicken.get(j).c - house.get(i).c);
						min = Math.min(min, dist);
					}
				}
				
				cityChickenDist += min; // 각 집의 치킨 거리를 더함
			}
			
			minCityChickenDist = Math.min(cityChickenDist, minCityChickenDist);
			return;
		}
		
		// 탐색 범위
		for(int i = idx; i < chicken.size(); i++) {
			if(!visited[i]) { // 방문 여부 검사
				visited[i] = true; // 방문처리
				dfs(depth + 1, i + 1);
				visited[i] = false; // 백트래킹
			}
		}
		
		
	}

}
