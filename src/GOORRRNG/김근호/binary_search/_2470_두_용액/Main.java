package GOORRRNG.김근호.binary_search._2470_두_용액;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int findOptimalValue(int[] arr, int value, int startIdx, int endIdx) {
        int l = startIdx, r = endIdx;
        int optimalAbsSum = Integer.MAX_VALUE;
        int optimalValue = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            int sum = value + arr[m];
            int absSum = Math.abs(sum);
            if (optimalAbsSum > absSum) {
                optimalValue = arr[m];
                optimalAbsSum = absSum;
            }
            if (sum < 0) l = m + 1;
            else if (sum > 0) r = m - 1;
            else return arr[m]; // 최적값
        }
        return optimalValue; // 최적값
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        // 1. 이분 탐색을 위해 정렬을 한다.
        Arrays.sort(arr);

        // 2. 각 용액에 대해 0과 가까운 최적이 되는 용액을 이분 탐색을 통해 찾는다.
        int optimalBestSum = Integer.MAX_VALUE;
        int optimalFirstValue = -1;
        int optimalSecondValue = -1;
        for (int i=0; i<n-1; i++) {
            int optimalValue = findOptimalValue(arr, arr[i],i+1, n-1);
            // 3. 각 용액 중 가장 작은 값이 되는 최적이 되는 용액을 찾는다.
            int optimalAbsSum = Math.abs(arr[i] + optimalValue);
            if(optimalBestSum > optimalAbsSum) {
                optimalBestSum = optimalAbsSum;
                optimalFirstValue = arr[i];
                optimalSecondValue = optimalValue;
            }
        }

        // 4. 정답을 출력한다.
        System.out.println(optimalFirstValue + " " + optimalSecondValue);
    }
}
