import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr, n, m));
    }

    private static int solution(int[] arr, int n, int m) {
        int answer = 0;

        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[n -1];

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(possible(arr, mid) >= m) {
                answer = mid;
                lt = mid+1;
            }else {
                rt = mid-1;
            }
        }
        return answer;
    }

    //공유기의 갯수 판단하는 로직
    private static int possible(int[] arr, int mid) {
        int cnt = 1;
        int sub = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i]-sub >= mid){
                cnt++;
                sub = arr[i];
            }
        }

        return cnt;
    }
}