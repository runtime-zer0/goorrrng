package GOORRRNG.김근호.queue._1966_프린터_큐;

import java.util.*;

class Document {
    int index;
    int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Queue<Document> q = new LinkedList<>();
            Integer[] priorityArr = new Integer[n];
            for (int i = 0; i < n; i++) {
                priorityArr[i] = sc.nextInt();
                q.offer(new Document(i, priorityArr[i]));
            }

            Arrays.sort(priorityArr, Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                while (q.peek().priority != priorityArr[i]) {
                    q.offer(q.poll());
                }

                if (q.peek().index == m) {
                    System.out.println(i + 1);
                    break;
                }
                q.poll();
            }
        }
    }
}
