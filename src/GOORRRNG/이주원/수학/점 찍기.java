class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(long x = 0; x <= d; x += k) {
            answer += Math.floor(Math.sqrt((long)d*(long)d - x*x)) / (long) k + 1;
        }
        return answer;
    }
}