### 문제

---

0번부터 n-1번까지 작업번호가 있는 n개의 작업이 있다.

각 작업은 [호출시간, 실행시간]으로 정보가 표현된다.

예를 들어 어떤 작업의 정보가[2, 3] 이면 0초부터 시작하여 흐르는 시간에서 2초에 작업호출되어 대기상태에 들어가며 자 신의 차례가 되면 3초동안 실행된 뒤 종료된다.

cpu는 다음과 같은 규칙에 의해서 작업을 실행시킨다.

1) 한 번에 한 개의 작업을 할 수 있고, 한 번 실행된 작업은 중간에 멈추지 않는다.

2) 대기상태에 있는 작업이 많을 경우 그 중 실행시간이 가장 작은 작업을 먼저 처리하며, 실 행시간이 같은 작업의 경우는 작업번호가 작은 것을 먼저 처리한다.

3) cpu는 한 작업이 끝나면 바로 다른 작업을 할 수 있습니다. 만약 어떤 작업이 5초에 끝나 면 5초에 바로 다른 작업을 할 수 있다.

매개변수 tasks에 0번 작업부터 순서대로 각 작업의 정보가 주어지면 cpu가 처리하는 작업의 순서대로 작업번호를 배열에 담아 반환하는 프로그램을 작성하라.

### 입출력 예

---

<img width="596" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202024-05-09%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%207 13 39" src="https://github.com/runtime-zer0/goorrrng/assets/147473025/f2ca4736-8ddc-476b-814b-374dbcae19bb">

### 제한사항

---

- tasks의 길이는 10,000 이하의 자연수다.
- 각 작업의 호출시간과 실행시간은 10,000을 넘지 않는다.

### 입력예제 1번 설명

---

1초에 1번 작업을 실행해서 3초에 끝낸다.

3초에 3번 작업을 실행해서 4초에 끝낸다.

4초에 0번 작업을 실행해서 7초에 끝낸다.

8초에 2번 작업을 실행해서 10초에 끝낸다.

10초에 4번 작업을 실행해서 12초에 끝낸다.

### 코드

---

```java
public static int[] solution(int[][] tasks){
    int n = tasks.length;
    int[] answer = new int[n];
    
    LinkedList<int[]> programs = new LinkedList<>();
    for(int i = 0; i < n; i++){
        programs.add(new int[]{tasks[i][0], tasks[i][1], i});
    }
    programs.sort(Comparator.comparingInt(a -> a[0]));
    
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    int firstTime = 0, idx = 0;
    while(!programs.isEmpty() || !pq.isEmpty()){
        if(pq.isEmpty()) {
            firstTime = Math.max(firstTime, programs.peek()[0]);
        }
        
        while(!programs.isEmpty() && programs.peek()[0] <= firstTime){
            int[] x = programs.pollFirst();
            pq.add(new int[]{x[1], x[2]});
        }
        
        int[] ex = pq.poll();
        firstTime = firstTime + ex[0];
        answer[idx++] = ex[1];
    }
    
    return answer;
}

public static void main(String[] args){
    System.out.println(Arrays.toString(solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
    System.out.println(Arrays.toString(solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
    System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
    System.out.println(Arrays.toString(solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
}
```