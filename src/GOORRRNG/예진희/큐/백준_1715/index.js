const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : '/goorrrng/goorrrng/src/GOORRRNG/예진희/큐/백준_1715/test.txt';
const input = fs.readFileSync(filePath).toString().split('\n');

let arr = input.slice(1, input.length - 1).map(x => +x);

arr.sort((a,b) => b - a);
let ans = 0;

let binary = (num) => {
    let lo = -1, hi = arr.length;
    while(lo+1 < hi){
        let mid = Math.floor((lo+hi) / 2);
        if(arr[mid] < num){
            hi = mid;
        }else{
            lo = mid;
        }
    }
    return hi;
}
while(arr.length > 1){
    let min = arr.pop() + arr.pop();
    let idx = binary(min);
    ans += min;
    arr.splice(idx,0,min);
}
console.log(ans);
