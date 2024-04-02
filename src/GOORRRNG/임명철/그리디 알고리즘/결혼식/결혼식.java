import javax.lang.model.type.ArrayType;
import java.util.*;

class Info implements Comparable<Info>{
    int time;
    char state;

    public Info(int time,char state){
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Info o){
        if(this.time == o.time) return this.state - o.state;
        return this.time - o.time;
    }
}

public class Main {
    static int n;
    static ArrayList<Info> arr;

    public int solution(ArrayList<Info> arr){
        int answer = 0;
        int cnt = 0;

        for(Info info : arr){
            if(info.state == 's'){
                cnt++;
            }else{
                cnt--;
            }

            answer = Math.max(answer,cnt);
        }
        return answer;
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr.add(new Info(x, 's'));
            arr.add(new Info(y, 'e'));
        }

        Collections.sort(arr);

        System.out.println(T.solution(arr));
    }
}
