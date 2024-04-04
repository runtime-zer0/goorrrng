import java.util.*;

public class Main {
    static int[] unf;
    public static int Find(int v){
        if(v == unf[v]) return unf[v];
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int x,int y){
        int FindX = Find(x);
        int FindY = Find(y);
        if(FindX != FindY) unf[FindX] = FindY;
    }
    public static void main(String args[]) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i] = i;

        for(int i=1; i<=m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            Union(a,b);
        }

        int k = sc.nextInt();
        int l = sc.nextInt();
        int fk = Find(k);
        int fl = Find(l);

        if(fk == fl) System.out.println("YES");
        else System.out.println("NO");

    }
}