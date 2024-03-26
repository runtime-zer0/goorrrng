import java.util.Scanner;

public class Main{
    static int n,total;
    static int[] arr;
    static int[] comparArr;
    static String answer = "NO";

    //부분집합을 생성하는 DFS 로직
    public static void DFS(int L){
        //부분집합을 생성한경우
        if(L == n){
            int sum = 0;

            for(int i=0; i<n; i++){
                if(comparArr[i] == 1) sum += arr[i];
            }

            if(sum * 2 == total) answer = "YES";
        }
        //부분집합에 들어갈 값이 남은 경우
        else{
            comparArr[L] = 1;
            DFS(L+1);
            comparArr[L] = 0;
            DFS(L+1);
        }
    }
    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n];
        comparArr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        DFS(0);
        System.out.println(answer);
    }
}