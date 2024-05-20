package GOORRRNG.공태현.hashing_time_parsing.같은_빈도수_만들기;

import java.util.Arrays;
import java.util.HashMap;

public class 같은_빈도수_만들기 {

    public static int[] solution(String s){
        int[] answer = new int[5];
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char val : s.toCharArray()){
            hashMap.put(val, hashMap.getOrDefault(val, 0)+1);
        }

        int maxVal = Integer.MIN_VALUE;
        String tmp = "abcde";
        for(char key : tmp.toCharArray()){
            if(hashMap.getOrDefault(key, 0) > maxVal){
                maxVal = hashMap.getOrDefault(key, 0);
            }
        }

        for (int i = 0; i < tmp.length(); i++) {
            answer[i] = maxVal - hashMap.getOrDefault(tmp.charAt(i), 0);
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution("aaabc")));
        System.out.println(Arrays.toString(solution("aabb")));
        System.out.println(Arrays.toString(solution("abcde")));
        System.out.println(Arrays.toString(solution("abcdeabc")));
        System.out.println(Arrays.toString(solution("abbccddee")));
    }
}
