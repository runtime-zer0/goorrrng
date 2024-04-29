import java.util.*;

public class Main {
    static int n;
    static int[] prev1,prev2,expect;

    //첫번째 전구를 킬때, 안킬때 2가지 경우에서 둘다 안되면 -1, 하나라도 된다면 그 중 최솟값을 구한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int ans1 = 1, ans2 = 0;

        String prevStr = sc.next();
        String expectStr = sc.next();

        prev1 = new int[n];
        prev2 = new int[n];
        expect = new int[n];

        for(int i=0; i<n; i++){
            prev1[i] = prevStr.charAt(i) - '0';
            prev2[i] = prevStr.charAt(i) - '0';
            expect[i] = expectStr.charAt(i) - '0';
        }

        prev1[0] = 1 - prev1[0];
        prev1[1] = 1 - prev1[1];

        for(int i=1; i<n; i++){
            //처음 전구를 조작했을 때
            if(prev1[i-1] != expect[i-1]){
                prev1[i-1] = 1 - prev1[i-1];
                prev1[i] = 1 - prev1[i];
                ans1++;
                if(i != n-1) prev1[i+1] = 1 - prev1[i+1];
            }

            //처음 전구를 조작하지 않았을 때
            if(prev2[i-1] != expect[i-1]){
                prev2[i-1] = 1 - prev2[i-1];
                prev2[i] = 1 - prev2[i];
                ans2++;
                if(i != n-1) prev2[i+1] = 1 - prev2[i+1];
            }

        }
        if(prev1[n-1] != expect[n-1]) ans1 = Integer.MAX_VALUE;
        if(prev2[n-1] != expect[n-1]) ans2 = Integer.MAX_VALUE;

        if(ans1 == Integer.MAX_VALUE && ans2 == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(Math.min(ans1,ans2));
    }
}