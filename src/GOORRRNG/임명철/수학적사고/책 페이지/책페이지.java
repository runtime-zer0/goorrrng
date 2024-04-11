import java.util.*;

public class Main {
    static int digit,start,end;
    static int[] pageNum;

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        digit = 1;
        start = 1;
        end = sc.nextInt();

        pageNum = new int[10];

        while(start <= end){

            //start부터 -> 즉 1부터 9까지 돌면서 counting
            while(start % 10 != 0 && start <= end){
                counting(start,digit);
                start++;
            }

            //입력값의 마지막자릿수부터 0까지 돌면서 counting
            while(end % 10 != 9 && start <= end){
                counting(end, digit);
                end--;
            }

            //아래에서 end /=10 으로 반복문을 돌기 때문에 end가 마지막자리일때 즉, 계산이 끝날때 break;
            if(start > end) break;


            start /= 10;
            end /= 10;

            //start와 end수 사이에 0~9 숫자의 개수를 추가해주는 로직
            for(int i=0; i<10; i++){
                pageNum[i] += (end - start + 1) * digit;
            }

            //반복문을 한번 돌면 즉 자릿수 하나를 계산하면 10을 곱해서 다음 자리수로 넘어간다.
            digit *= 10;
        }

        for(int x : pageNum) System.out.print(x + " ");
    }

    //start or end가 들어왔을 때 그 수에 들어있는 숫자들을 계산하는 로직
    static void counting(int num, int digit){
        while(num > 0){
            pageNum[num % 10] += digit;
            num /= 10;
        }
    }
}