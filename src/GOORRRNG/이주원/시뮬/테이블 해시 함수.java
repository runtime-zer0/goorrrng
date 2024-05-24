import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col-1] == o2[col-1])
                return o2[0] - o1[0];
            else
                return o1[col-1] - o2[col-1];
        });
        int answer = getS_i(data[row_begin-1], row_begin);
        for(int i = row_begin; i < row_end; i++) {
            answer ^= getS_i(data[i], i+1);
        }
        return answer;
    }
    
    int getS_i(int[] array, int i) {
        return Arrays.stream(array)
            .reduce(0, (total, n) -> total + n % i);
    }
}