import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i : tangerine)
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        
        int[] selected = {0};
        int answer = (int) counts
            .values()
            .stream()
            .sorted((o1, o2) -> o2 - o1)
            .takeWhile(i -> {
                selected[0] += i;
                return selected[0] < k;
            })
            .count() + 1;
        return answer;
    }
}