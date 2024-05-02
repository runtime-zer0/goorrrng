package GOORRRNG.공태현.data_structure.최대_길이_연속_수열;

import java.util.HashSet;

public class 최대_길이_연속_수열 {

    public static int solution(int[] nums){
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int val : nums) {
            set.add(val);
        }

        for(int val : set) {
            if (set.contains(val - 1)) {
                continue;
            }

            int cnt = 0;
            while (set.contains(val)) {
                cnt++;
                val++;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
