package GOORRRNG.공태현.hashing_time_parsing.서로_다른_빈도수_만들기;

import java.util.HashMap;
import java.util.HashSet;

public class 서로_다른_빈도수_만들기 {
    public static int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashSet<Integer> ch = new HashSet<>();
        for (char val : s.toCharArray()) {
            hashMap.put(val, hashMap.getOrDefault(val, 0) + 1);
        }

        for (char key : hashMap.keySet()) {
            while (ch.contains(hashMap.get(key))) {
                answer++;
                hashMap.put(key, hashMap.get(key) - 1);
            }
            if (hashMap.get(key) == 0) {
                continue;
            }
            ch.add(hashMap.get(key));
        }

        return answer;
    }
}
