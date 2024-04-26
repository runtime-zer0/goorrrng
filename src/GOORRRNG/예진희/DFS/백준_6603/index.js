const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let answer = '';

for (let tc = 0; tc < input.length - 1; tc++) {
  // 공백을 기준으로 나누어 배열로 저장
  const testCase = input[tc].split(' ');
  // 첫 번째 수는 k이므로 숫자로 변환하여 저장
  const k = Number(testCase[0]);
  // 집합 S의 수를 배열로 저장
  const arr = testCase.slice(1).map(Number);
  // 방문 여부를 저장할 배열 초기화
  const visited = new Array(k).fill(false);
  // 결과를 저장할 배열 초기화
  const result = [];
  let temp = '';

  function dfs(start) {
    // 배열의 길이가 6이면
    if (result.length === 6) {
      // 하나의 조합이 완성되므라 완성된 조합을 temp에 추가
      temp += result.join(' ') + '\n';
      return;
      }
      
    for (let i = start; i < k; i++) {
      // 이미 방문한 경우 다음으로 넘어감
      if (visited[i]) continue;
      // 방문 여부를 표시하고 결과 배열에 추가
      visited[i] = true;
      result.push(arr[i]);
      // 다음 원소를 탐색하기 위해 재귀 호출
      dfs(i + 1);
      // 탐색이 끝나면 결과 배열과 방문 여부를 복원
      result.pop();
      visited[i] = false;
    }
  }

    dfs(0);
  answer += temp + '\n';
}

console.log(answer);
