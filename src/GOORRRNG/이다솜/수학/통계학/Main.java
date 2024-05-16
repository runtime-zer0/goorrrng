package 수학.통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int calculateAverage(int[] arr) {
        double average = 0, sum = 0;
        for (int i : arr) {
            sum += i;
        }

        average = Math.round(sum / arr.length); //반올림 후 저장

        return (int) Math.ceil(average);
    }

    static int calculateMedian(int[] arr) {
        return arr[(arr.length/2)];
    }

    static int calculateMode(int[] arr) {
        int cnt[] = new int[8001]; //입력값의 범위가 -4000 ~ 4000 이기 때문에 범위를 8001로 설정
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE; //비교 변수

        for (int i : arr) {
            if (i < 0) cnt[Math.abs(i) + 4000]++; //음수면 4000을 더해서 cnt 배열의 해당 인덱스 증가
            else cnt[i]++; // cnt 배열의 해당 인덱스 증가
        }

        int idx = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0 && cnt[i] > max) { //cnt 배열의 i번째 인덱스가 증가했고, 그 값이 max 보다 크면
                max = cnt[i];
                idx = i;
            }
        }

        for (int i = 0; i < cnt.length; i++) {
            int com = i;
            if (cnt[i] == max) {  //cnt의 인덱스 i의 값이 max(최빈값)이랑 같을 때
                if (i > 4000) { // i가 4000보다 크면
                    com -= 4000;
                    com *= -1;
                    list.add(com); //리스트에 com 추가
                } else {
                    list.add(com);
                }
            }
        }
        Collections.sort(list); // 리스트에 들어있는 최빈값이 다수일 경우도 있기 때문에 오름차순 정렬

        if (list.size() > 1) return list.get(1); // 최빈값이 다수일 때 원하는 값이 두번째로 작은 값이기 때문에 1번 인덱스 리턴
        else return list.get(0); // 최빈값이 하나이면 0번 인덱스 리턴
    }

    static int calculateRange(int[] arr) {
        return arr[arr.length-1] - arr[0]; // 배열의 마지막 숫자에서 첫번째 숫자를 빼기
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(calculateAverage(arr));
        System.out.println(calculateMedian(arr));
        System.out.println(calculateMode(arr));
        System.out.println(calculateRange(arr));

        br.close();
    }
}
