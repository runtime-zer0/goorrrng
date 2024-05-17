import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class OilBank implements Comparable<OilBank>{
    int dist, oil;

    public OilBank(int dist, int oil){
        this.dist = dist;
        this.oil = oil;
    }


    @Override
    public int compareTo(OilBank o) {
        return this.dist - o.dist;
    }
}

public class Main {
    static int n,l,p;
    static int ans = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        PriorityQueue<OilBank> pQ = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pQ.offer(new OilBank(a,b));
        }

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        //기름 기준 내림차순
        PriorityQueue<Integer> fuel = new PriorityQueue<>(Collections.reverseOrder());

        while(p < l){
            while (!pQ.isEmpty() && pQ.peek().dist <= p) {
                fuel.add(pQ.poll().oil);
            }

            if (fuel.isEmpty()) {
                System.out.println(-1);
                return;
            }

            ans++;
            p += fuel.poll();
        }

        System.out.println(ans);
    }
}