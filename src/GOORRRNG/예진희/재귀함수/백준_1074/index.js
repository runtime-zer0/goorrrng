let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

const [N, r, c] = input.split(' ').map(Number);
let result = 0;

result = solution(0,2**N-1,0,2**N-1,r,c,result);
console.log(result);

function solution(row_start,row_end,col_start,col_end,r,c,num){
    const length = row_end-row_start+1;
    if(length===1)
        return num;
    const row_mid = (row_start+row_end)/2;
    const col_mid = (col_start+col_end)/2;
    const len = (length/2)**2;
    /// 제 1 사분면
    if(r<row_mid&&c<col_mid)
        return solution(row_start,Math.floor(row_mid),col_start,Math.floor(col_mid),r,c,num);
    /// 제 2 사분면
    else if(r<row_mid&&c>col_mid){
        num+=len;
        return solution(row_start,Math.floor(row_mid),Math.ceil(col_mid),col_end,r,c,num);
    }
    /// 제 3 사분면
    else if(r>row_mid&&c<col_mid){
        num+=2*len;
        return solution(Math.ceil(row_mid),row_end,col_start,Math.floor(col_mid),r,c,num);
    }
    /// 제 4 사분면
    else{
        num+=3*len;
        return solution(Math.ceil(row_mid),row_end,Math.ceil(col_mid),col_end,r,c,num);
    }
}
