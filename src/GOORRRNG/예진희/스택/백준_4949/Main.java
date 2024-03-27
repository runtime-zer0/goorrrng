package GOORRRNG.예진희.스택.백준_4949;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in); // 문자열 입력

        Stack<Character> stack = new Stack<>(); // 괄호 저장 스텍

        while(true) {
            String str = kb.nextLine(); // 문자열 입력받음

            if(str.equals(".")) { // 입력이 "."이면 종료
                return;
            }

            for(int i = 0; i < str.length(); i++) {
                char a = str.charAt(i); // 문자 가져오기

                if(a == '(' || a == '[' || a == ')' || a == ']') {
                    if(stack.isEmpty()) {
                        stack.push(a);
                    } else if(a == ')' && stack.peek() == '(') { // 닫는 괄호 ')'이고 스택의 최상위 데이터가 '(' 이라면
                        stack.pop(); // '(' 제거
                    } else if(a == ']' && stack.peek() == '[') { // 닫는 괄호 ']'이고 스택의 최상위 데이터가 '[' 이라면
                        stack.pop(); // '[' 제거
                    } else { // 여는 괄호인 경우
                        stack.push(a); // 스택에 추가
                    }
                }
            }

            if(stack.isEmpty()) {
                System.out.println("yes"); // 스택이 비어있기 때문에 yes
            } else {
                System.out.println("no"); // 스택이 비어있지 않기 때문에 no
            }
            stack.clear(); // 혹시 몰라서 추가
        }
    }
}
