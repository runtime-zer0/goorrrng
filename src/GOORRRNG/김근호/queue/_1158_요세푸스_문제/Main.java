package GOORRRNG.김근호.queue._1158_요세푸스_문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            for (int i = 0; i < k-1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}
