package GOORRRNG.예진희.큐.백준_19638;
import java.util.*;

public class Baek_19638 {
    static int n,h,t;
    static PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt(); // 거인의 수
        h=sc.nextInt(); // 센티의 키
        t=sc.nextInt(); // 뿅망치 제한 횟수

        // 키 큰 순서대로 정렬
        for(int i=0;i<n;i++)
            pq.add(sc.nextInt());

        // 뿅망치 제한 횟수만큼 수행
        for(int i=0;i<t;i++) {
            int giant=pq.peek(); // 가장 키가 큰 거인 선택

            if(giant<h) {
                System.out.println("YES");
                System.out.println(i); // 뿅망치 사용 횟수
                System.exit(0);
            }

            else if(giant>1) {
                pq.poll();
                pq.add(giant/2);
            }
        }

        if(pq.peek()<h) {
            System.out.println("YES");
            System.out.println(t); // 뿅망치 사용 횟수 출력
        }
        // 센티보다 큰 거인이 있는 경우
        else {
            System.out.println("NO");
            System.out.println(pq.peek()); // 가장 키가 큰 거인의 키 출력
        }
    }
}