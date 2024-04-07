# [D3] N-Queen - 2806

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GKs06AU0DFAXB)

### 성능 요약

메모리: 35,188 KB, 시간: 144 ms, 코드길이: 3,625 Bytes

### 제출 일자

2024-04-07 19:43

### 문제

8\*8 체스보드에 8개의 퀸을 서로 공격하지 못하게 놓는 문제는 잘 알려져 있는 문제이다.

퀸은 같은 행, 열, 또는 대각선 위에 있는 말을 공격할 수 있다. 이 문제의 한가지 정답은 아래 그림과 같다.

![nqueen](https://github.com/meanzi3/Programmers/assets/120402129/469e326b-a126-409a-a7da-dd9b0bf566a3)

이 문제의 조금 더 일반화된 문제는 Franz Nauck이 1850년에 제기했다.

N\*N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수는 몇가지가 있을까?

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

<br><br><br><br>

---

### 입력

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 하나의 자연수 N(1 ≤ N ≤ 10)이 주어진다.

<br>

### 출력

각 테스트 케이스마다 ‘#x ’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

<br>

### 입출력 예시

![image](https://github.com/meanzi3/Programmers/assets/120402129/a3f39897-b063-4288-8604-780f5d544504)

<br><br>

> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do
