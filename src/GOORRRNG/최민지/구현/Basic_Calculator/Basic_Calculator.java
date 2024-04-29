import java.util.*;

class Solution {
    public int calculate(String s) {
        if(s == null) return 0; // null 처리

        Stack<Integer> stack = new Stack<Integer>(); // () 처리를 위한 스택

        int number = 0; // 숫자
        int sign = 1; // 부호
        int answer = 0; // 정답

        for(int i = 0; i < s.length(); i++){
          char c = s.charAt(i);
          if(Character.isDigit(c)){
            // 이전 숫자랑 합쳐줌
            number = 10 * number + (int)(c - '0');
          } else if(c == '+' ){
            // 이전 까지의 숫자 * 현재 부호를 정답에 더함
            // 현재 부호를 1로, 숫자는 0으로 초기화
            answer += number * sign;
            sign = 1;
            number = 0;
          } else if(c == '-'){
            // 이전 까지의 숫자 * 현재 부호를 정답에 더함
            // 현재 부호를 -1로, 숫자는 0으로 초기화
            answer += number * sign;
            sign = -1;
            number = 0;
          } else if(c == '('){
            // 이전까지의 결과와 부호를 스택에 넣고
            // 결과를 0으로 설정하여 괄호 안에서 새 결과를 계산
            stack.push(answer);
            stack.push(sign);
            sign = 1;
            answer = 0;
          } else if(c == ')'){
            // 스택에서 해당 괄호 쌍 ('(') 앞의 부호를 꺼내서 곱하고,
            // 해당 괄호 쌍 ('(') 앞까지의 결과를 꺼내서 더한다.
            answer += sign * number;
            number = 0;
            answer *= stack.pop();
            answer += stack.pop();
          }
        }

      // +,- 이후 마지막 더하기
      answer += sign * number;
      return answer;
    }
}
