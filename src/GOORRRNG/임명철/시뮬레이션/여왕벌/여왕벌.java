import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n,m;
    static int[][] larva;
    static int[][] grow;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grow = new int[m][3];
        larva = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(larva[i] , 1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                grow[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {

            for (int j = n - 1; j >= 0; j--) {
                if(grow[i][0] != 0){
                    grow[i][0]--;
                }else if(grow[i][1] != 0){
                    grow[i][1]--;
                    larva[j][0] += 1;
                }else if(grow[i][2] != 0){
                    grow[i][2]--;
                    larva[j][0] += 2;
                }
            }

            for (int j = 1; j < n; j++) {
                if(grow[i][0] != 0){
                    grow[i][0]--;
                }else if(grow[i][1] != 0){
                    grow[i][1]--;
                    larva[0][j] += 1;
                }else if(grow[i][2] != 0){
                    grow[i][2]--;
                    larva[0][j] += 2;
                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                larva[i][j]= Math.max(larva[i-1][j], Math.max(larva[i-1][j-1], larva[i][j-1]));
            }
        }

        StringBulider sb = new StringBulider();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(larva[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}