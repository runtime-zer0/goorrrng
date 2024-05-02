import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Ball implements Comparable<Ball>{
    int index;
    int color;
    int size;

    public Ball(int index, int color,int size) {
        this.index = index;
        this.color = color;
        this.size = size;
    }

    @Override
    public int compareTo(Ball o) {
        return this.size- o.size;
    }
}

public class Main {
    static ArrayList<Ball> arr = new ArrayList<>();
    static int[] colorList, ans;

    public static void main(String[] args) throws IOException, Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int totalSum = 0;

        colorList = new int[n+1];
        ans = new int[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            arr.add(new Ball(i,color,size));
        }

        Collections.sort(arr);

        int totalsum =0;
        int idx = 0;
        for(int i=0; i<n; i++) {
            Ball a = arr.get(i);
            Ball b = arr.get(idx);

            while(b.size < a.size) {
                totalsum += b.size;
                colorList[b.color] += b.size;

                b = arr.get(++idx);
            }

            ans[a.index] = totalsum - colorList[a.color];
        }


        for(int num : ans) System.out.println(num);
    }

}
