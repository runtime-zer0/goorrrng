const input = require("fs").readFileSync("/dev/stdin");

const answer = [];
const hanoi = (disk, start, end, middle) => {
  if (disk == 1) return answer.push(`${start} ${end}`);

  hanoi(disk - 1, start, middle, end);
  answer.push(`${start} ${end}`);
  hanoi(disk - 1, middle, end, start);
};

console.log((2n ** BigInt(input) - 1n).toString());

if (input > 20) return;
hanoi(input, 1, 3, 2);
console.log(answer.join("\n"));