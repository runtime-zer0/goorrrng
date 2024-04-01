import java.util.*;

//정보를 답는 클래스 Compareble로 정렬방식 설정
class Info implements Comparable<Info>{
    int start;
    int end;

    public Info(int start, int end) {
        this.start = start;
        this.end = end;
    }

    //this의 필드에서 파라미터로 받는 필드값을 빼주면 오름차순
    //역으로 파라미터로 받는 필드값에서 this필드값을 빼주면 내림차순
    @Override
    public int compareTo(Info o) {
        return this.end- o.end;
    }
}

public class Main {
    static int n;
    static ArrayList<Info> arr;

    public int solution(int n, ArrayList<Info> arr){
        Collections.sort(arr);
        int answer = 1;
        int end = arr.get(0).end;
        for(int i=0; i<n; i++){
            if(arr.get(i).start >= end){
                answer++;
                end = arr.get(i).end;
            }
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
            int y  = sc.nextInt();
            arr.add(new Info(x,y));
        }


        System.out.println(T.solution(n, arr));
    }
}
