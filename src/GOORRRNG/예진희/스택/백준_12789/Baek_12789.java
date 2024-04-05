package GOORRRNG.예진희.스택.백준_12789;
import java.util.*;
import java.io.*;
public class Baek_12789 {
    public static boolean isDreamSnack(String[] lines) {
        Stack<Integer> stack = new Stack<Integer>();
        int order = 1;

        for(String line :lines) {
            int curr = Integer.parseInt(line);
            while(!stack.isEmpty() && order == stack.peek()){
                stack.pop();
                order++;
            }
            if(curr == order) {
                order++;
            }else {
                stack.push(curr);
            }
        }
        while(!stack.isEmpty()) {
            //대기열이 순서에 맞지 않으면 false
            int curr = stack.pop();
            if(curr!=order++) return false;
        }
        //모든 과정 통과시 true
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] lines = br.readLine().split(" ");
        System.out.println(isDreamSnack(lines)?"Nice":"Sad");

        br.close();
    }
}
