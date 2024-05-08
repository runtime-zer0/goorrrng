class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length-1};
        int[] sum = new int[sequence.length+1];
        sum[1] = sequence[0];
        int i = 0, j = 0;
        while(i < sequence.length && j <= i) {
            int result = sum[i+1] - sum[j];
            if(result == k) {
                if(i - j < answer[1] - answer[0]) {
                    answer[1] = i;
                    answer[0] = j;
                    if(i - j == 0) break;
                }
                i++;
                if(i < sequence.length)
                    sum[i+1] = sum[i] + sequence[i];
            } else if(result < k) {
                i++;
                if(i < sequence.length)
                    sum[i+1] = sum[i] + sequence[i];
            }
            else if(result > k) {
                j++;
            }
        }
        return answer;
    }
}