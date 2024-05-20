import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int w : weights) {
            answer += map.getOrDefault(w*1.0, 0)
                + map.getOrDefault(w*2.0/3.0, 0)
                + map.getOrDefault(w*3.0/4.0, 0)
                + map.getOrDefault(w/2.0, 0);
            map.put(w*1.0, map.getOrDefault(w*1.0, 0)+1);
        }
        return answer;
    }
}