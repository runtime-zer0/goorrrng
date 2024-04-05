import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int length = number.length() - k;
        int i = 0;
        while(length-- > 0) {
            char max = number.charAt(i);
            int maxIndex = i;
            for(int j = i+1; j < k + answer.length() + 1; j++) {
                if(number.charAt(j) > max) {
                    max = number.charAt(j);
                    maxIndex = j;
                }
            }
            answer.append(max);
            i = maxIndex+1;
        }
        
        
        return answer.toString();
    }
}

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int length = number.length() - k;
        
        for(int i = 0; i < number.length(); i++) {
            while(k > 0 && !stack.isEmpty() && stack.peek() < number.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        
        StringBuilder answer = new StringBuilder();
        while(length-- > 0) {
            answer.append(stack.removeLast());
        }
        return answer.toString();
    }
}