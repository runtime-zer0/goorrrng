import java.io.*;
import java.util.*;

public class 루돌프의_반란 {
	
	static class Santa {
		int sr;
		int sc;
		int score; // 점수
		boolean isOuted; // 아웃여부
		int isSleep; // 기절 상태
	}
	
	private static String[] input;
	
	private static int N;// 맵 크기
	private static int M; // 턴 수
	private static int P; // P명의 산타
	private static int C; // 루돌프의 힘
	private static int D; // 산타의 힘
	private static int rr, rc; // 루돌프 위치
	
	private static int[][] map;
	
	private static Santa[] santas;
	private static int numSanta; // 산타 수
	
	// 86249317
	private static int[] dr = {-1, 0, 1, 0, -1, 1, 1, -1};
	private static int[] dc = {0, 1, 0, -1, 1, 1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/codeTree_02/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		P = Integer.parseInt(input[2]);
		C = Integer.parseInt(input[3]);
		D = Integer.parseInt(input[4]);
		
		map = new int[N+1][N+1];
		
		input = br.readLine().split(" ");
		rr = Integer.parseInt(input[0]);
		rc = Integer.parseInt(input[1]);
		map[rr][rc] = 99; // 루돌프 위치 저장
		
		santas = new Santa[P + 1];
		santas[0] = new Santa(); // 0번 산타
		for(int i = 0; i < P; i++) {
			input = br.readLine().split(" ");
			int pNum = Integer.parseInt(input[0]);
			santas[pNum] = new Santa();
			santas[pNum].sr = Integer.parseInt(input[1]);
			santas[pNum].sc = Integer.parseInt(input[2]);
			map[santas[pNum].sr][santas[pNum].sc] = pNum;
			numSanta ++;
		} // 산타 정보 저장
		
		while(M-- > 0) {
			
			// 모든 산타가 아웃되면 종료 
			if(numSanta <= 0) {
				break;
			}
			
			// 가까운 산타 번호 구하고
			int santaNum = findNearSanta();
			
			// 루돌프가 이동할 방향 구함
			int rudolphDir = getRudolphDir(santaNum);
			
			
			// 루돌프 턴
			moveRudolph(rudolphDir);
			
			
			// 산타 턴
			for(int i = 1; i <= P; i++) {
				
				santas[i].isSleep--;
				
				// 아웃 확인
				if(santas[i].isOuted) continue;
				
				// 기절상태 확인
				if(santas[i].isSleep > 0) {
					continue;
				} 
				
				int minDis = Integer.MAX_VALUE;
				int baseDis = getDistance(rr, rc, santas[i].sr, santas[i].sc);
				boolean crused = false;
				int dir = -1;
				
				// 가까운 방향 확인
				for(int j = 0; j< 4; j++) {
					int nextR = santas[i].sr + dr[j];
					int nextC = santas[i].sc + dc[j];
					if(!isInRange(nextR, nextC)) continue;
					
					// 루돌프와 충돌한다면
					if(map[nextR][nextC] == 99) {
						crused = true; 
						map[santas[i].sr][santas[i].sc] = 0;
						santas[i].sr = nextR;
						santas[i].sc = nextC;
						santas[i].score += D;
						santas[i].isSleep = 2;
						
						// 반대 방향으로 이동
						moveSanta(i, (j + 2) % 4, D);
						
						map[nextR][nextC] = 99;
						
						break;
					}
					
					// 빈 칸이라면
					if(map[nextR][nextC] == 0) {
						// 최소 거리구하기
						int dis = getDistance(rr, rc, nextR, nextC);
						// 루돌프와 가까워지는 게 아니라면 패스
						if(dis >= baseDis) continue;
						if(minDis > dis) {
							minDis = dis;
							dir = j;
						}
					}
				}
				
				// 최소 거리로 한 칸 이동 시키기
				if (!crused && dir >= 0) { 
				    moveSanta(i, dir, 1);
				}
				
			}
			
			// 턴 끝날 때마다 생존한 산타는 점수++
			for(int i = 1; i <= P; i++) {
				if(santas[i].isOuted)
					continue;
				santas[i].score++;
			}
			
		}
		
		// 정답 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= P; i++){
			sb.append(santas[i].score).append(" ");
		}
		System.out.println(sb.toString());
		
    }
	
	// 가까운 산타 찾기
	private static int findNearSanta() {
		int min = Integer.MAX_VALUE;
		int idx = 0; // 최소 거리를 구하는 데 몇 번 산타인지도 알기 위해
		for(int i = 1; i <= P; i++) {
			if(santas[i].isOuted) continue; // 탈락 확인
			
			// 산타들 마다 루돌프랑 거리 확인
			int dis = getDistance(rr, rc, santas[i].sr, santas[i].sc);
			
			if(min > dis) {
				min = dis;
				idx = i;
			} else if (min == dis){ 
				// 가까운 산타가 2명 이상이면, r좌표가 큰 산타, 동일하면 c 좌표가 큰 산타
				if(santas[idx].sr < santas[i].sr) {
					min = dis;
					idx = i;
				} else if(santas[idx].sr == santas[i].sr) {
					if(santas[idx].sc < santas[i].sc) {
						min = dis;
						idx = i;
					}
				}
			}
		}
		
		return idx;
	}
	
	
	private static int getRudolphDir(int santaNum) {
		
		int sr = santas[santaNum].sr;
		int sc = santas[santaNum].sc;
		
		if(rr > sr) {
			if(rc > sc) {
				return 7;
			}
			if(rc < sc) {
				return 4;
			}
			return 0;
		}
		if(rr < sr) {
			if(rc > sc) {
				return 6;
			}
			if(rc < sc) {
				return 5;
			}
			return 2;
		}
		if(rc > sc) {
			return 3; 
		}
		if(rc < sc) {
			return 1;
		}
		
		return -1;
	}
	
	private static void moveRudolph(int RudolphDir) {
		int nextR = rr + dr[RudolphDir];
		int nextC = rc + dc[RudolphDir]; // 이동할 좌표
		
		if(map[nextR][nextC] != 0) { // 이동할 자리에 산타가 있으면
			// 산타는 C만큼의 점수 얻음. C칸 밀려남
			int pNum = map[nextR][nextC];
			// 1턴 기절
			santas[pNum].isSleep = 3;
			santas[pNum].score += C;
			moveSanta(pNum, RudolphDir, C);
		}
		
		// 움직이기
		map[nextR][nextC] = map[rr][rc];
		map[rr][rc] = 0; 
		rr = nextR;
		rc = nextC;
	}
	
	private static void moveSanta(int pNum, int dir, int step) {
		map[santas[pNum].sr][santas[pNum].sc] = 0;
		int nextR = santas[pNum].sr + dr[dir] * step;
		int nextC = santas[pNum].sc + dc[dir] * step; // 이동할 좌표
		
		// 범위 확인
		if(!isInRange(nextR, nextC)) {
			// 아웃
			santas[pNum].isOuted = true;
			numSanta --;
			return;
		}
		if(map[nextR][nextC] != 0) {
			// 다른 산타가 있으면 이동
			int nextPnum = map[nextR][nextC];
			moveSanta(nextPnum, dir, 1); // 한 칸 이동
		}
		
		santas[pNum].sr = nextR;
		santas[pNum].sc = nextC;
		map[nextR][nextC] = pNum; // 이동
	}
	
	// 거리 계산 함수
	private static int getDistance(int rr, int rc, int sr, int sc) {
		return (rr - sr) * (rr - sr) + (rc - sc) * (rc - sc);
	}
	
	// 범위 확인 함수
	private static boolean isInRange(int r, int c) {
		if(r > N || r <= 0 || c > N || c <= 0)	return false;
		return true;
	}
}

