import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n+1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int rt = 0;
        int lt = 0;
        int total =0;

        while(lt <= n && rt <= n){
            if(total >= m && answer > rt-lt) answer = rt-lt;

            if(total < m) {
                total += arr[rt];
                rt++;
            }
            else {
                total -= arr[lt];
                lt++;
            }
        }


    }

}