let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const n = Number(input.shift()); // 전체 사람 수
const [a, b] = input.shift().split(' ').map(Number); // a, b 두 사람의 번호
const m = Number(input.shift()); // 관계의 개수
const arr = input.map((v) => v.split(' ').map(Number)); // 부모-자식 관계 배열

let answer, degree = 0;
let visited = Array(n + 1).fill(false);
let graph = [...Array(n + 1)].map(() => []);

arr.map(([from, to]) => {
  graph[from].push(to);
  graph[to].push(from);
});


const dfs = (start, depth) => {
  // start가 b에 도달하면 depth answer에 저장
  if (start === b) answer = depth;

    // 현재 노드 방문처리 안 되어있다면 방문 처리하고 dfs 실행하는데 depth는 1씩 증가
	for (const v of graph[start]) {
      if (!visited[v]) {
        visited[v] = true;
        dfs(v, depth + 1);
      }
	}
};

dfs(a, degree);
answer ? console.log(answer) : console.log(-1);