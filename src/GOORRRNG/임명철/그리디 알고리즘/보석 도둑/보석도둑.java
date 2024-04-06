import java.util.*;

class Info implements Comparable<Info>{
    int M;
    int V;

    public Info(int M,int V){
        this.M = M;
        this.V = V;
    }

    @Override
    public int compareTo(Info ob){
        return this.M - ob.M;
    }
}

public class Main {

    static int N,K;

    static ArrayList<Info> arr = new ArrayList<Info>();
    static int[] C;

    public static void main(String args[]) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        C = new int[K];

        for(int i=0; i<N; i++){
            int M = sc.nextInt();
            int V = sc.nextInt();

            arr.add(new Info(M,V));
        }

        Collections.sort(arr);

        for(int i=0; i<K; i++){
            C[i] = sc.nextInt();
        }

        Arrays.sort(C);

        long answer = 0;
        int idx = 0;

        //값을 기준으로 내림차순
        PriorityQueue<Info> pQ = new PriorityQueue<>((o1,o2) -> o2.V - o1.V);
        for(int i=0; i<K; i++){
            while(idx < N && arr.get(idx).M <= C[i]){
                Info curr = arr.get(idx++);
                pQ.add(new Info(curr.M, curr.V));
            }

            if(!pQ.isEmpty()) answer += pQ.poll().V;
        }

        System.out.println(answer);
    }
}