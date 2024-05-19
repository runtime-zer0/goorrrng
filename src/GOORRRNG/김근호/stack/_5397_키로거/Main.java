package GOORRRNG.김근호.stack._5397_키로거;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            char[] charArray = sc.next().toCharArray();
            Deque<Character> frontCursor = new ArrayDeque<>();
            Deque<Character> backCursor = new ArrayDeque<>();
            for (char c : charArray) {
                if (c == '-') {
                    if (!frontCursor.isEmpty()) {
                        frontCursor.pollLast();
                    }
                } else if (c == '<') {
                    if (!frontCursor.isEmpty()) {
                        backCursor.offerLast(frontCursor.pollLast());
                    }
                } else if (c == '>') {
                    if (!backCursor.isEmpty()) {
                        frontCursor.offerLast(backCursor.pollLast());
                    }
                } else {
                    frontCursor.offerLast(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!frontCursor.isEmpty()) sb.append(frontCursor.pollFirst());
            while (!backCursor.isEmpty()) sb.append(backCursor.pollLast());
            System.out.println(sb);
        }
    }
}
