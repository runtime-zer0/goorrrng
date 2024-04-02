package GOORRRNG.김근호.string._13223_소금_폭탄;

import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String current = sc.next();
//        String drop = sc.next();
//        int p = 0;
//        int[] time = new int[3];
//
//        for(int i=0; i<3; i++){
//            time[i] = Integer.valueOf(drop.substring(p, p+2))-Integer.valueOf(current.substring(p, p+2));
//            p = p + 3;
//        }
//        if(time[2]<0) {
//            time[2] += 60;
//            time[1]--;
//        }
//        if(time[1]<0) {
//            time[1] += 60;
//            time[0]--;
//        }
//        if(time[0]<=0) {
//            time[0] += 24;
//        }
//
//        System.out.printf("%02d:%02d:%02d",time[0],time[1],time[2]);
//    }
//}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentStr = sc.next();
        String dropStr = sc.next();

        String[] currentTime = currentStr.split(":");
        int currentHour = Integer.parseInt(currentTime[0]);
        int currentMinute = Integer.parseInt(currentTime[1]);
        int currentSecond = Integer.parseInt(currentTime[2]);
        int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;

        String[] dropTime = dropStr.split(":");
        int dropHour = Integer.parseInt(dropTime[0]);
        int dropMinute = Integer.parseInt(dropTime[1]);
        int dropSecond = Integer.parseInt(dropTime[2]);
        int dropSecondAmount = dropHour * 3600 + dropMinute * 60 + dropSecond;

        int diffSecondAmount = dropSecondAmount - currentSecondAmount;
        if(diffSecondAmount<=0){
            diffSecondAmount += 24 * 3600;
        }

        int hour = diffSecondAmount / 3600;
        int minute = (diffSecondAmount % 3600) / 60;
        int second = (diffSecondAmount % 3600) % 60;

        System.out.printf("%02d:%02d:%02d", hour, minute, second);
    }
}
