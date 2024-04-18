import java.util.*;

class Group{
    int totalCandy,cnt;

    public Group(int w, int cnt){
        this.totalCandy =w;
        this.cnt= cnt;
    }
}

public class Main {
    static int n,m,k;
    static int[] candy;
    static int totalCandy,cnt;
    static List<ArrayList<Integer>> friends;
    static ArrayList<Group> groups;
    static boolean[] check;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        friends = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<=n; i++) friends.add(new ArrayList<>());

        candy= new int[n+1];
        check= new boolean[n+1];

        for(int i=1; i<=n; i++){
            candy[i] = sc.nextInt();
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        DivideGroup();
        getCandy();
    }


    private static void DivideGroup() {
        groups = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(!check[i]){
                totalCandy = 0;
                cnt= 0;
                DFS(i);
                groups.add(new Group(totalCandy,cnt));
            }
        }
    }

    private static void DFS(int v) {
        check[v] = true;
        totalCandy += candy[v];
        cnt += 1;
        for(int nv : friends.get(v)){
            if(check[nv]){
                continue;
            }
            DFS(nv);
        }
    }

    private static void getCandy() {
        int dp[][] = new int[2][k+1];

        for (Group group : groups) {
            for(int i=0; i<=k; i++){
                if(i >= group.cnt){
                    dp[1][i] = Math.max(dp[0][i], dp[0][i-group.cnt] + group.totalCandy);
                }else{
                    dp[1][i] = dp[0][i];
                }
            }

            for(int i=0; i<k; i++){
                dp[0][i] = dp[1][i];
            }
        }

        System.out.println(dp[1][k]);
    }
}