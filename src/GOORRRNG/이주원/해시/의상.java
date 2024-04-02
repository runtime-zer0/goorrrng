import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> clothesMap = new HashMap<>();
        
        for(String[] wear : clothes){
            if(clothesMap.get(wear[1]) == null)
                clothesMap.put(wear[1], 0);
            
            clothesMap.put(wear[1], clothesMap.get(wear[1]) + 1);
        }
        
        int answer = 1;
        for(String key : clothesMap.keySet()){
            answer *= clothesMap.get(key) + 1;
        }
        
        return answer - 1;
    }
}