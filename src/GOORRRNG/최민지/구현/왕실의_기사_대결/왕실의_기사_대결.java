import java.io.*;

public class 왕실의_기사_대결 {
	static class Knight {
		int r;
		int c;
		int h;
		int w;
		int k;
		int damage;

		Knight() {

		}

		Knight(String[] str) {
			r = Integer.parseInt(str[0]) - 1;
			c = Integer.parseInt(str[1]) - 1;
			w = Integer.parseInt(str[2]);
			h = Integer.parseInt(str[3]);
			k = Integer.parseInt(str[4]);
		}
	}

	static Knight[] knights; // 기사 정보 저장 배열
	static String[] inputs;
	static int L, N, Q;
	static int[][] map, knightMap;                

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/practice/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		inputs = in.readLine().split(" ");
		L = Integer.parseInt(inputs[0]);
		N = Integer.parseInt(inputs[1]);
		Q = Integer.parseInt(inputs[2]);

		map = new int[L][L];
		knightMap = new int[L][L];
		for (int i = 0; i < L; i++) {
			inputs = in.readLine().split(" ");
			for (int j = 0; j < L; ++j) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		} // 맵 초기화
		
		knights = new Knight[N + 1];
		knights[0] = new Knight();
		for (int i = 1; i <= N; i++) {
			knights[i] = new Knight(in.readLine().split(" "));
			for (int x = 0; x < knights[i].w; ++x) {
				for (int y = 0; y < knights[i].h; ++y) {
					knightMap[x + knights[i].r][y + knights[i].c] = i;
				}
			}
		} // 기사 맵 초기화

		// 명령
		for (int i = 0; i < Q; i++) {
			inputs = in.readLine().split(" ");
			int selected = Integer.parseInt(inputs[0]);
			int dir = Integer.parseInt(inputs[1]);
			simulation(selected, dir);
		}

		// 정답
		int answer = 0;
		for (Knight knight : knights)
			if (knight.k > knight.damage)
				answer += knight.damage;

		System.out.println(answer);
	}

	// 상, 우, 하, 좌
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	private static void simulation(int selected, int dir) {
		// 명령을 받은 기사가 죽은 경우
		if (knights[selected].damage >= knights[selected].k)
			return;

		// 움직일 수 없는 경우
		if (!canMove(selected, dir))
			return;

		// 움직이기
		// 명령을 받은 기사인지 확인하는 isOrdered 파라미터 이용
		move(selected, dir, true);

	}

	private static void move(int selected, int dir, boolean isOrdered) {
		boolean flag = false;
		int baseX = knights[selected].r;
		int baseY = knights[selected].c; // 기준점
		for (int i = 0; i < knights[selected].w; ++i) {
			for (int j = 0; j < knights[selected].h; ++j) {
				int x = knights[selected].r + i;
				int y = knights[selected].c + j; // 범위들 좌표 구성
				int nextX = x + dx[dir];
				int nextY = y + dy[dir]; // 이동할 좌표

				int nearByPlayer = knightMap[nextX][nextY];

				// 이동할 칸에 다른 기사가 있는 경우
				if (nearByPlayer > 0 && nearByPlayer != selected) {
					// 다른 기사 옮기기
					move(nearByPlayer, dir, false);
				}

				// 함정이 있다면
				if (map[nextX][nextY] == 1 && !isOrdered)
					knights[selected].damage++;

				// 현재칸 비우기 및 최초 1회만 기준점 옮기기
				knightMap[x][y] = 0;
				if (!flag) {
					flag = true;
					baseX = baseX + dx[dir];
					baseY = baseY + dy[dir];
				}
			}
		} // 기존의 범위들을 비우게 됨

		knights[selected].r = baseX;
		knights[selected].c = baseY; // 기준점 갱신

		for (int i = 0; i < knights[selected].w; ++i) {
			for (int j = 0; j < knights[selected].h; ++j) {
				int x = knights[selected].r + i;
				int y = knights[selected].c + j;
				if (knights[selected].k > knights[selected].damage)
					knightMap[x][y] = selected; // 기사 범위 새로 설정
				else
					knightMap[x][y] = 0; // 죽었으면 0으로 설정
			}
		} 
	}

	public static boolean canMove(int selected, int dir) {
		for (int i = 0; i < knights[selected].w; ++i) {
			for (int j = 0; j < knights[selected].h; ++j) {
				int nextX = knights[selected].r + i + dx[dir];
				int nextY = knights[selected].c + j + dy[dir];
				// 이동할 좌표 구하기

				// 범위 확인
				if (!isInRange(nextX, nextY))
					return false;

				// 벽 확인
				if (map[nextX][nextY] == 2)
					return false;

				int nearByPlayer = knightMap[nextX][nextY];

				// 이동할 칸에 다른 기사가 있는 경우
				if (nearByPlayer > 0 && nearByPlayer != selected) {
					// 다른 기사가 이동할 수 있는지도 확인
					if (!canMove(nearByPlayer, dir))
						return false;
				}
			}
		}
		return true; // 인접한 기사들도 다 이동이 가능한 지 확인하게 됨
	}

  // 범위 확인 함수
	public static boolean isInRange(int x, int y) {
		if (0 <= x && x < L && 0 <= y && y < L)
			return true;
		return false;
	}
}
