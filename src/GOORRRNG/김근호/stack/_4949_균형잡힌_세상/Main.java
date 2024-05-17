package GOORRRNG.김근호.stack._4949_균형잡힌_세상;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (true) {
            char[] charArray = br.readLine().toCharArray();
            if (charArray.length == 1 && charArray[0] == '.') break;
            Deque<Character> s = new ArrayDeque<>();
            boolean answer = true;
            for (char c : charArray) {
                if (c == '[' || c == '(') s.addLast(c);
                else if (c == ']' || c == ')') {
                    if(s.isEmpty() || (c == ']' ? s.peekLast() != '[' :  s.peekLast() != '(' )) {
                        answer = false;
                        break;
                    }
                    s.removeLast();
                }
            }
            if (!s.isEmpty()) answer = false;
            sb.append(answer ? "yes\n" : "no\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
