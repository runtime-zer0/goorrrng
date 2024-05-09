package GOORRRNG.김근호.queue._15828_Router;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        while (true) {
            int i = sc.nextInt();
            if (i > 0 ) {
                if (q.size() < n) {
                    q.offer(i);
                }
            }
            else if (i == 0) q.poll();
            else break;
        }

        if (q.size() == 0) System.out.print("empty");
        else {
            while (!q.isEmpty()) {
                System.out.print(q.poll()+ " ");
            }
        }
    }
}
