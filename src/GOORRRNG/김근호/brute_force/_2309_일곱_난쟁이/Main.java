package GOORRRNG.김근호.brute_force._2309_일곱_난쟁이;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int[] answer = new int[7];
        int sum = 0;
        boolean stop = false;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    int index = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k!=i && k!=j) {
                            answer[index++] = arr[k];
                        }
                    }
                    stop = true;
                    break;
                }
            }
            if(stop) break;
        }
        Arrays.sort(answer);
        for(int i : answer){
            System.out.println(i);
        }
    }
}

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] arr = new int[9];
//        ArrayList<Integer> answer = new ArrayList<>();
//        int sum = 0;
//        boolean stop = false;
//        for(int i=0; i<9; i++){
//            arr[i] = sc.nextInt();
//            sum += arr[i];
//        }
//        for(int i=0; i<9; i++){
//            for(int j=i+1; j<9; j++){
//                if(sum-arr[i]-arr[j]==100){
//                    for(int k=0; k<9; k++){
//                        if(k!=i&&k!=j){
//                            answer.add(arr[k]);
//                        }
//                    }
//                    stop = true;
//                    break;
//                }
//            }
//            if(stop) break;
//        }
//        Collections.sort(answer);
//        for(int i : answer){
//            System.out.println(i);
//        }
//    }
//}