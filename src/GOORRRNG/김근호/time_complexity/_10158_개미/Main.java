package GOORRRNG.김근호.time_complexity._10158_개미;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();
        int currentX = (p + t) % (2 * w);
        int currentY = (q + t) % (2 * h);
        if(currentX>w) currentX = 2 * w - currentX;
        if(currentY>h) currentY = 2 * h - currentY;
        System.out.println(currentX+" "+currentY);
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int w = sc.nextInt();
//        int h = sc.nextInt();
//        int currentX = sc.nextInt();
//        int currentY = sc.nextInt();
//        int time = sc.nextInt();
//        int deltaX = 1;
//        int timeX = time % (2 * w);
//        int deltaY = 1;
//        int timeY = time % (2 * h);
//        for (int i = 0; i < timeX; i++) {
//            if (currentX == w) deltaX = -1;
//            else if (currentX == 0) deltaX = 1;
//            currentX += deltaX;
//        }
//        for (int i = 0; i < timeY; i++) {
//            if (currentY == h) deltaY = -1;
//            else if (currentY == 0) deltaY = 1;
//            currentY += deltaY;
//        }
//        System.out.println(currentX + " " + currentY);
//    }
//}