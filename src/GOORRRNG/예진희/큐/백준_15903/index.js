class PQ {
  constructor() {
    this.arr = []
  }
  enqueue(ele) {
    const len = this.arr.length
    let check = false

    for (let i = 0; i < len; i++) {
      const cur = this.arr[i]
      if (cur > ele) {
        this.arr.splice(i, 0, ele)
        check = true
        break;
      }
    }

    if (!check) this.arr.push(ele)
  }
  dequeue() {
    return this.arr.shift()
  }
}

let fs = require('fs');
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

// console.log('__filename:', __filename); console.log('__dirname:', __dirname);
// __filename: /path/to/your/script.js
// ??

const [N, M] = input.shift().split(' ')
const cards = input[0].split(' ').map(BigInt)

const pq = new PQ()

cards.forEach(ele => {
  pq.enqueue(ele)
})
for (let i = 0; i < M; i++) {
  const a = pq.dequeue()
  const b = pq.dequeue()
  pq.enqueue(a+b)
  pq.enqueue(a+b)
}

console.log(String(pq.arr.reduce((a,b) => a+b)))