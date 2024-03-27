import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n-1;
        
        for(int i = 0; i < wires.length; i++) {
            Set<Integer> nodes = new HashSet<>();
            
            for(int j = 0; j < wires.length; j++) {
                for(int k = 0; k < wires.length; k++) {
                    if(i == k) continue;
                    
                    if(nodes.isEmpty() 
                       || nodes.contains(wires[k][0]) 
                       || nodes.contains(wires[k][1])) {
                        nodes.add(wires[k][0]);
                        nodes.add(wires[k][1]);
                    }
                }
            }
            answer = Math.min(answer, Math.abs(nodes.size()*2-n));
        }
        
        return answer;
    }
}