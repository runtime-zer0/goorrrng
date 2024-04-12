package GOORRRNG.김근호.prefix_sum._11659_구간_합_구하기_4;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] acc = new int[n+1];

        st = new StringTokenizer(br.readLine());
        // 문제의 배열을 입력 받고 누적 합 배열을 만든다.
        for(int i=1; i<=n; i++) { // 인덱스 1부터
            arr[i] = Integer.parseInt(st.nextToken());
            acc[i] = acc[i-1] + arr[i];
        } // 시간 복잡도 : O(N)

        // 누적 합 배열에서 i번째 수부터 j번째 수까지 합을 출력한다.
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.write((acc[j]-acc[i-1] + "\n"));
        }// 시간 복잡도 : O(M)
        bw.flush();
    }
}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] arr = new int[n+1];
//        int[] acc = new int[n+1];
//
//        // 문제의 배열을 입력 받고 누적 합 배열을 만든다.
//        for(int i=1; i<=n; i++) { // 인덱스 1부터
//            arr[i] = sc.nextInt();
//            acc[i] = acc[i-1] + arr[i];
//        } // 시간 복잡도 : O(N)
//
//        // 누적 합 배열에서 i번째 수부터 j번째 수까지 합을 출력한다.
//        while(m-- > 0) {
//            int i = sc.nextInt();
//            int j = sc.nextInt();
//            System.out.println(acc[j]-acc[i-1]);
//        }// 시간 복잡도 : O(M)
//    }
//}