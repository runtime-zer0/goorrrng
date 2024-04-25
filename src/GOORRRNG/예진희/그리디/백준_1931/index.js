const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [n, ...arr] = input;
let answer = 0;
const times = arr
  .map((num) => num.split(' ').map((num) => +num))
  .sort((a, b) => {
    if (a[1] === b[1]) {
      return a[0] - b[0];
    } else {
      return a[1] - b[1];
    }
  });

let et = 0;
times.forEach((time) => {
  if (time[0] >= et) {
    answer++;
    et = time[1];
  }
});

console.log(answer);
