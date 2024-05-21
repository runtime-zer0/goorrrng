import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int R, C, K; // 숲의 크기 R, C, 정령의 수 K
	private static String[] input; // 입력값 처리 
	private static int[][] map; // 맵
	private static boolean[][] isExit; // 출구 표시 맵을 따로 만듦.
	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine().split(" ");
		
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		
		answer = 0;
		
		// 맵 초기화
		map = new int[R+3][C];
		isExit = new boolean[R+3][C];
		
		for(int i = 1; i <= K; i++) {
			input = br.readLine().split(" ");
			int sc = Integer.parseInt(input[0])-1; // 출발하는 열
			int d = Integer.parseInt(input[1]); // 방향 정보 (0-북, 1-동, 2-남, 3-서)
			down(0, sc, d, i);
		}
		
		System.out.println(answer);
		
	}
	
	// 남쪽으로 한 칸
	// 남쪽으로 갈 수 없다면 서쪽으로 회전하면서 굴러서 한 칸 내려 감
	// 2번 방법으로도 갈 수 없다면 동쪽으로 회전하면서 굴러서 한 칸 내려감
	private static void down(int y, int x, int d, int id) {
		if(isPossible(y+1, x)) {
			// 남쪽으로 한 칸
			down(y+1, x, d, id);
		} else if(isPossible(y+1, x-1)) {
			// 왼쪽 아래로 굴러서 한 칸
			down(y+1, x-1,(d+3) % 4, id);
		} else if(isPossible(y+1, x+1)) {
			// 오른쪽 아래로 굴러서 한 칸
			down(y+1, x+1, (d+1) % 4, id);
		} else {
			// 더 이상 움직일 수 없을 때
			
			// 범위를 벗어나는 경우 터뜨림
			// 좌상단, 우하단 검사
			if(!inRange(y-1, x-1) || !inRange(y+1, x+1)) {
				for(int i = 0; i < R+3; i++) {
					for(int j = 0; j < C; j++) {
						map[i][j] = 0;
						isExit[i][j] = false;
					}
				}
			}
			
			// 그렇지 않다면 점수 계산
			else {
				map[y][x] = id; // 정령 번호로 채우기
				for(int i = 0; i < 4; i++) {
					// 상하좌우도 번호 채우기
					map[y + dy[i]][x + dx[i]] = id;
				}
				// 출구 표시
				isExit[y + dy[d]][x + dx[d]] = true;
				
				// bfs로 정령이 최대로 내려갈 수 있는 행을 계산
				answer += bfs(y, x) - 2;
			}
		}
	}
	
	// 이동 가능 확인 함수
	private static boolean isPossible(int y, int x) {
		// 기본 골렘 범위 확인
		boolean flag = x-1 >= 0 && x+1 < C && y+1 < R+3;
		
		// 맵에서 움직이는 칸이 빈 칸인지 다 확인
		flag = flag && (map[y - 1][x - 1] == 0);
        flag = flag && (map[y - 1][x] == 0);
        flag = flag && (map[y - 1][x + 1] == 0);
        flag = flag && (map[y][x - 1] == 0);
        flag = flag && (map[y][x] == 0);
        flag = flag && (map[y][x + 1] == 0);
        flag = flag && (map[y + 1][x] == 0);
		
		return flag;
	}
	
	// 범위 확인 함수
	private static boolean inRange(int y, int x) {
		return y >= 3 && y < R + 3 && x >= 0 && x < C;
	}
	
	// 정령 점수 계산 bfs 함수
	private static int bfs(int y, int x) {
		int score = y; // 시작
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[R+3][C];
		
		q.offer(new int[] {y,x});
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = tmp[0] + dy[i];
				int nx = tmp[1] + dx[i];
				
				// 범위, 방문 여부 확인
				if(!inRange(ny, nx) || visited[ny][nx]) continue;
				
				// 같은 골렘 내부이거나 탈출구 이거나
				if(map[ny][nx] == map[tmp[0]][tmp[1]] || (isExit[tmp[0]][tmp[1]] && map[ny][nx] != 0)) {
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = true;
					// 최댓값 갱신
					score = Math.max(score, ny);
				}
			}
		}
		
		return score;
	}
}
