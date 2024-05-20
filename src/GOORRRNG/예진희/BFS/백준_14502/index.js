const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const lab = require('fs')
  .readFileSync(filePath)
  .toString()
  .trim()
  .split('\n')
  .map((v) => v.split(' ').map(Number));
  
const [N, M] = lab.shift();
const empty = []; // 빈 곳의 좌표를 담을 배열
const virus = []; // 바이러스 퍼진 곳의 좌표를 담을 배열
const safeArea = []; // 안전영역 카운트한 수를 담을 배열
const dir = [[0, 1], [0, -1], [-1, 0], [1, 0]]; // 상하좌우 인접 네방향 x,y좌표

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
	// 연구소 지도의 빈 공간(0)의 위치(x,y좌표) empty 배열에 담기
    if (!lab[i][j]) empty.push([i, j]);

	// 연구소 지도의 바이러스(2)의 위치(x,y좌표) virus 배열에 담기 
    else if (lab[i][j] == 2) virus.push([i, j]);
  }
}

// 빈 공간에 벽 3개를 세우는 반복문
for (let i = 0; i < empty.length; i++) {
  for (let j = i + 1; j < empty.length; j++) {
    for (let k = j + 1; k < empty.length; k++) {
      const tmpLab = JSON.parse(JSON.stringify(lab)); // 입력값 배열 깊은 복사

	  // 빈 공간 세 곳에 각각 벽 만들기
      tmpLab[empty[i][0]][empty[i][1]] = 1;
      tmpLab[empty[j][0]][empty[j][1]] = 1;
      tmpLab[empty[k][0]][empty[k][1]] = 1;

      const bfs = () => {
        const tmpVirus = JSON.parse(JSON.stringify(virus)); // 바이러스 배열 깊은 복사
        let vCnt = 0; // 바이러스 감염 횟수 카운트할 변수
        while (tmpVirus.length) {
          const [x, y] = tmpVirus.shift();

		  // 현재 위치 기준으로 인접한 네방향 탐색할 반복문
          for (let i = 0; i < 4; i++) { 
            const nx = x + dir[i][0];
            const ny = y + dir[i][1];

			// 해당 위치가 연구소 지도 밖으로 벗어나지 않았고, 빈 공간(0)인 경우
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !tmpLab[nx][ny]) {
              tmpLab[nx][ny] = 2; // 바이러스 전파
              vCnt++; // 바이러스 감염 횟수 증가
              tmpVirus.push([nx, ny]);
            }
          }
        }
		// 안전영역 크기 = empty배열 길이 - 바이러스 감염된 곳의 수 - 벽 3곳;
        safeArea.push(empty.length - vCnt - 3);
      };

      bfs();
    }
  }
}
console.log(Math.max(...safeArea)); // 안전영역 중 최댓값 출력