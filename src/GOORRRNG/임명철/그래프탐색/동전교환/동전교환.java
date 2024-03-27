import java.util.*;

public class Main {
    static int n,k,sum;
    static Integer[] arr;
    static int answer;

    public static void DFS(int L){
        if(L >= answer) return;
        if(sum > k) return;
        if(sum == k) answer = Math.min(answer,L);
        else{
            for(int i=0; i<n; i++){
                sum += arr[i];
                DFS(L+1);
                sum -= arr[i];
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new Integer[n];
        sum  = 0;
        answer = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        k = sc.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());

        DFS(0);
        System.out.println(answer);
    }
}
