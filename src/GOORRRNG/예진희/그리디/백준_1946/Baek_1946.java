package GOORRRNG.예진희.그리디.백준_1946;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Grade implements Comparable<Grade> {
    int a; // 서류
    int b; // 면접

    // 생성자
    Grade(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // 서류심사 점수를 기준으로 오름차순으로 정렬
    public int compareTo(Grade o) {
        if(this.a > o.a) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Baek_1946 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int T = kb.nextInt();

        for (int t = 0; t < T; t++) {
            int N = kb.nextInt();
            ArrayList<Grade> list = new ArrayList<>(); // Grade 리스트 생성

            for (int i = 0; i < N; i++) {
                int a = kb.nextInt();
                int b = kb.nextInt();

                list.add(new Grade(a, b));
            }

            Collections.sort(list); // 서류 점수 기준 오름차순 정렬

            int ans = 1; // 서류 1등은 무조건 통과
            int min = list.get(0).b; // 면접 점수 최소값
            for (int i = 1; i < N; i++) { // 서류 2등부터 시작
                if (list.get(i).b < min) { // 이전의 최소 면접 점수보다 낮으면 통과
                    ans++;
                    min = list.get(i).b; // 최소 점수 갱신
                }
            }
            System.out.println(ans);
        }
    }
}