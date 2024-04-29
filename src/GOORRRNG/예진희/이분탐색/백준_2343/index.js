const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, M] = input.shift().split(' ').map(Number);
const classes = input[0].split(' ').map(Number);

let start = Math.max(...classes);

let end = classes.reduce((acc, cur) => acc + cur);

let answer = Number.MAX_SAFE_INTEGER;
while (start <= end) {
  let cnt = 1;
  let mid = Math.floor((start + end) / 2);
  let tmp = 0;
  for (let i = 0; i < classes.length; i++) {
    if (tmp + classes[i] <= mid) {
      tmp += classes[i];
    } else {
      tmp = 0 + classes[i];
      cnt++;
      if (cnt > M) break;
    }
  }

  if (cnt > M) {
    start = mid + 1;
  }

  if (cnt <= M) {
    if (answer >= mid) answer = mid;
    end = mid - 1;
  }
}

console.log(answer);