package GOORRRNG.김근호.simulation._2817_ALPS식_투표;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Staff implements Comparable<Staff>{
    char c;
    int chip;

    Staff (char c){
        this.c = c;
    }

    public int compareTo(Staff s){
        return this.c - s.c;
    }
}

class Score implements Comparable<Score> {
    double score;
    int idx;

    public Score(double score, int idx) {
        this.score = score;
        this.idx = idx;
    }

    public int compareTo(Score s){
        return (int) (s.score - this.score);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        // 대회 전체 참가자 5% 미만 득표를 얻은 스태프 제외
        double cut = x * 0.05;
        ArrayList<Staff> arr = new ArrayList<>();
        ArrayList<Score> scores = new ArrayList<>();
        int cnt = 0; // 후보 인덱스
        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            int vote = sc.nextInt();
            if (vote >= cut) {
                // 남은 스태프들의 득표수를 1~14로 나눈 점수 집합을 구한다
                for (int j = 0; j < 14; j++) {
                    scores.add(new Score((double) vote / (j+1), cnt));
                }
                cnt++;
                arr.add(new Staff(c));
            }
        }

        // 전체 집합에서 14번째 후보까지 칩을 준다.
        Collections.sort(scores);
        for(int i=0; i<14; i++){
            arr.get(scores.get(i).idx).chip++;
        }

        // 스태프 이름을 사전순으로 스태프마다 받은 칩의 개수를 출력한다.
        Collections.sort(arr);
        for(Staff s : arr) {
            System.out.println(s.c+" "+s.chip);
        }
    }
}

// 오답 코드
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//class Staff implements Comparable<Staff>{
//    char c;
//    int vote;
//    double[] score;
//    int chip;
//
//    Staff (char c, int vote, double[] score){
//        this.c = c;
//        this.vote = vote;
//        this.score = score;
//    }
//
//    public int compareTo(Staff s){
//        return this.c - s.c;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int n = sc.nextInt();
//        // 대회 전체 참가자 5% 미만 득표를 얻은 스태프 제외
//        double cut = x * 0.05;
//        ArrayList<Staff> arr = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            char c = sc.next().charAt(0);
//            int vote = sc.nextInt();
//            if (vote >= cut) {
//                // 남은 스태프들의 득표수를 1~14로 나눈 점수 집합을 구한다
//                int cnt = 1;
//                double[] score = new double[14];
//                for (int j = 0; j < score.length; j++) {
//                    score[j] = (double) vote / cnt;
//                    cnt++;
//                }
//                arr.add(new Staff(c, vote, score));
//            }
//        }
//
//        // 집합 내에서 가장 큰 점수를 가진 스태프에게 1개의 칩을 준다.
//        for (int i = 0; i < 14; i++) {
//            int staff = 0;
//            double tmp = arr.get(staff).score[i];
//            for (int j = 1; j < arr.size(); j++) {
//                if (tmp < arr.get(j).score[i]) {
//                    tmp = arr.get(j).score[i];
//                    staff++;
//                }
//            }
//            arr.get(staff).chip++;
//            System.out.println(arr.get(0).score[i]);
//            System.out.println(arr.get(1).score[i]);
//            System.out.println(arr.get(2).score[i]);
//        }
//        // 스태프 이름을 사전순으로 스태프마다 받은 칩의 개수를 출력한다.
//        Collections.sort(arr);
//        for(Staff s : arr) {
//            System.out.println(s.c+" "+s.chip);
//        }
//    }
//}