import java.util.*;

public class Main {
    static int n,k;
    static boolean flag = false;
    static int[] combination;
    static int[] info;
    static int[] check;
    static int[][] memo = new int[15][15];

    public int combi(int n,int r){
        if(memo[n][r] > 0) return memo[n][r];
        if(n==r || r== 0) return 1;
        else return memo[n][r] = combi(n-1,r-1) + combi(n-1,r);
    }
    public void DFS(int L,int sum) {
        if(flag) return;
        if(L == n) {
            if(sum == k){
                for(int x : info) System.out.print(x +" ");
                flag = true;
            }
        }else{
            for(int i=1; i<=n; i++){
                if(check[i] == 0){
                    check[i] = 1;
                    info[L] = i;
                    DFS(L+1, sum+(info[L] * combination[L]));
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        combination = new int[n];
        info = new int[n];
        check = new int[n+1];

        for(int i=0; i<n; i++){
            combination[i] = T.combi(n-1,i);
        }

        T.DFS(0,0);
    }
}
