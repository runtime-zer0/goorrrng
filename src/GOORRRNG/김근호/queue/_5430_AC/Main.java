package GOORRRNG.김근호.queue._5430_AC;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            char[] ac = sc.next().toCharArray();
            int n = sc.nextInt();
            StringTokenizer st = new StringTokenizer(sc.next(), "[,]");
            Deque<String> dq = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                dq.offer(st.nextToken());
            }

            boolean isFlipped = false;
            boolean isValid = true;
            for (char c : ac) {
                if (c == 'D') {
                    if (dq.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if (isFlipped) dq.pollLast();
                    else dq.pollFirst();
                }
                else isFlipped = !isFlipped;
            }

            if (isValid) {
                StringBuilder sb = new StringBuilder();
                while (!dq.isEmpty()) {
                    sb.append(isFlipped ? dq.pollLast() : dq.pollFirst());
                    if (!dq.isEmpty()) sb.append(",");
                }
                System.out.println("[" + sb + "]");
            } else System.out.println("error");
        }
    }
}
