import java.util.*;

class Info implements Comparable<Info>{
    int money,time;

    public Info(int money,int time){
        this.money = money;
        this.time = time;
    }

    //시간을 기준으로 내림차순 정렬
    //내림차순은 현재(this)가 음수가 나와야한다.
    //즉 o.time-this.time은 음수이므로 내림차순이다.
    @Override
    public int compareTo(Info o) {
        return o.time - this.time;
    }
}

public class Main {
    static int n, max = Integer.MIN_VALUE;

    public int solution(ArrayList<Info> arr){
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        Collections.sort(arr);

        int idx = 0;
        for(int i=max; i>0; i--){
            while(idx< n){
                if(arr.get(idx).time < i) break;
                pQ.offer(arr.get(idx).money);
                idx++;
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }

        return answer;
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ArrayList<Info> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            int t = sc.nextInt();

            arr.add(new Info(m,t));
            if(max < t) max = t;
        }

        System.out.println(T.solution(arr));
    }
}