
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int y;
	int x;

	public Point( int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] map;
	static boolean[] visit;
	static int m;
	static int answer = Integer.MAX_VALUE;
	static ArrayList<Point> chicken = new ArrayList<>();
	static ArrayList<Point> house = new ArrayList<>();
	public static void DFS(int start, int cnt) {
		if(cnt==m){
			int chickenDis=0;
			for(Point home : house){
				int min=Integer.MAX_VALUE;
				for(int i = 0;i<chicken.size();i++){
					if(visit[i]){
					int dis = getDistance(home,chicken.get(i));
					min=Math.min(dis,min);
					}
				}
				chickenDis+=min;
			}
			answer=Math.min(answer,chickenDis);
			return;
		}
		for(int i = start;i<chicken.size();i++){
			if(visit[i]) continue;
			visit[i]=true;
			DFS(i+1,cnt+1);
			visit[i]=false;
		}


	}
	public static int getDistance(Point p1,Point p2){
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					house.add(new Point(i, j));
				else if (map[i][j] == 2)
					chicken.add(new Point(i, j));
				j++;
			}
		}
		visit=new boolean[chicken.size()];
		DFS(0,0);
		System.out.println(answer);
	}


}
