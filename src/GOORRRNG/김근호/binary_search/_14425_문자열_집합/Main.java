package GOORRRNG.김근호.binary_search._14425_문자열_집합;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean isExist(String[] arr, String x) {
        int l = 0, r = arr.length-1;
        while(l<=r) {
            int m = (l + r) / 2;
            int compareResult = arr[m].compareTo(x);
            if (compareResult < 0) l = m + 1;
            else if (compareResult > 0) r = m - 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] arr = new String[n];
        // N개의 문자열로 이루어진 집합 S를 입력
        for(int i=0; i<n; i++) {
            arr[i] = sc.next();
        }
        // 이분 탐색을 위해 정렬
        Arrays.sort(arr);
        // M개의 문자열 중에 집합 S에 포함되어 있는지 체크
        int cnt = 0;
        while(m-- > 0) {
            String x = sc.next();
            if(isExist(arr, x)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}