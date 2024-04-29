import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] s = new HashSet[8];
        for(int i = 0; i < s.length; i++)
            s[i] = new HashSet<>();
        
        for(int i = 0; i < s.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = -1; j < i; j++){
                sb.append(N);
            }
            s[i].add(Integer.parseInt(sb.toString()));
        }
        
        int answer = -1;
        for(int i = 0; i < s.length; i++) {
            for(int j = 0; j < i; j++) {
                for(int op1 : s[j]) {
                    for(int op2 : s[i-1-j]) {
                        s[i].add(op1 + op2);
                        s[i].add(op1 * op2);
                        s[i].add(op1 - op2);
                        if(op2 != 0)
                            s[i].add(op1 / op2);
                    }
                }
            }
            if(s[i].contains(number)){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}