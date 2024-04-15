package GOORRRNG.김근호.prefix_sum._19951_태상이의_훈련소_생활;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        // delta[b+1] 연산이 있으므로 n+2 크기로 만들어 준다.
        int[] delta = new int[n+2];
        for (int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
        }
        // 1. 각 지시에 따른 변화량 delta 기록하기
        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            delta[a] += k;
            delta[b+1] -= k;
        }
        // 2. 각 칸부터의 변화량을 적용한 accDelta 구하기
        int[] accDelta = new int[n+1];
        for(int i=1; i<=n; i++) {
            accDelta[i] = accDelta[i-1] + delta[i];
        }
        // 3. 변화량이 적용된 각 칸의 높이 출력하기
        for (int i=1; i<=n; i++) {
            System.out.print(arr[i] + accDelta[i] + " ");
        } // 시간 복잡도 : O(max(M+N))
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
//        for (int i=1; i<=n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        while (m-- > 0) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int k = sc.nextInt();
//            for(int j=a; j<=b; j++) {
//                arr[j] += k;
//            }
//        }
//        for (int i=1; i<=n; i++) {
//            System.out.print(arr[i]+ " ");
//        } // 시간 복잡도 : O(NM)
//        // 0 1 2 3 4 5 6 7 8 9 10
//        //   a       b
//    }
//}