package GOORRRNG.김근호.sorting._18870_좌표_압축;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Point implements Comparable<Point> {
    int x;
    int idx;

    public Point(int x, int idx) {
        this.x = x;
        this.idx = idx;
    }

    public int compareTo(Point o) {
        return this.x - o.x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> arr = new ArrayList<>();
        String[] inputs = br.readLine().split(" ");

        for(int i=0; i<n; i++) {
            arr.add(new Point(Integer.parseInt(inputs[i]), i));
        }

        Collections.sort(arr);
        int[] ans = new int[n];

        ans[arr.get(0).idx] = 0;
        int cnt = 0;
        for(int i=1; i<n; i++) {
            if(arr.get(i-1).x != arr.get(i).x) cnt++;
            ans[arr.get(i).idx] = cnt;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<n; i++) {
            bw.write(ans[i]+" ");
        }
        bw.flush();
    }
}

//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeSet;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
//        int n = Integer.parseInt(br.readLine());
//        Set<Integer> set = new TreeSet<>();
//        String[] inputs = br.readLine().split(" ");
//
//        for(int i=0; i<n; i++) {
//            set.add(Integer.parseInt(inputs[i]));
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        int idx = 0;
//        for (int i : set) {
//            map.put(i, idx++);
//        }
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        for(int i=0; i<n; i++) {
//            bw.write(map.get(Integer.parseInt(inputs[i]))+" ");
//        }
//        bw.flush();
//    }
//}

