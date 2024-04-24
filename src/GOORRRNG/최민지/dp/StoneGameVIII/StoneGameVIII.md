<h2><a href="https://leetcode.com/problems/stone-game-viii/">1872. Stone Game VIII</a></h2><h3>Hard</h3><hr><div>

<p>앨리스와 밥이 번갈아 가며 게임을 하는데, <strong>앨리스가 먼저 </strong>게임을 시작합니다.</p>

<p>일렬로 배열된 스톤이 n개 있습니다. 각 플레이어의 차례가 되면 스톤의 개수가 <strong>하나 보다 많을 때에</strong>, 다음을 수행합니다: </p>

1. 줄에서 가장 왼쪽에 있는 돌 x 개를 제거합니다. (`x > 1`)

2. <strong>제거한</strong> 스톤의 값의 <strong>합</strong>을 플레이어의 점수에 더합니다.

3. 그 합과 같은 값의 <strong>새 스톤</strong>을 행의 왼쪽에 놓습니다.

스톤이 한 줄에 <strong>하나만</strong> 남으면 게임이 종료됩니다.

앨리스와 밥의 <strong>점수 차이는</strong> `(앨리스의 점수 - 밥의 점수)`입니다. 앨리스의 목표는 점수 차이를 <strong>최대화</strong>하는 것이고, 밥의 목표는 점수 차이를 <strong>최소화</strong>하는 것입니다.

길이 n의 정수 배열 `stone`이 주어지고, `stone[i]`는 왼쪽에서 i번째 스톤의 값을 나타낼 때, 앨리스와 밥이 모두 <strong>최적으로</strong> 플레이할 경우 두 사람의 <strong>점수 차이</strong>를 반환합니다.

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> stones = [-1,2,-3,4,-5]
<strong>Output:</strong> 5
<strong>Explanation:</strong>
- 앨리스가 처음 4개의 수톤을 제거하고, (-1) + 2 + (-3) + 4 = 2 의 점수를 얻은 후, 2의 값을 가지는 스톤을 왼쪽에 놓습니다. stones = [2,-5].
- 밥이 2개의 스톤을 제거하고, 2 + (-5) = -3 의 점수를 얻은 후, -3의 값을 가지는 스톤을 왼쪽에 놓습니다. stones = [-3].
- 둘의 점수 차이는 2 - (-3) = 5 입니다.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> stones = [7,-6,5,10,5,-2,-6]
<strong>Output:</strong> 13
<strong>Explanation:</strong>
- 앨리스가 모든 스톤을 제거하고, 7 + (-6) + 5 + 10 + 5 + (-2) + (-6) = 13 의 점수를 얻은 후, 13의 값을 가지는 스톤을 왼쪽에 놓습니다. stones = [13].
- 둘의 점수 차이는 13 - 0 = 13 입니다.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> stones = [-10,-12]
<strong>Output:</strong> -22
<strong>Explanation:</strong>
- 이 게임에서 엘리스는 2개의 스톤만 제거할 수 있습니다. (-10) + (-12) = -22 의 점수를 얻은 후, -22의 값을 가지는 스톤을 왼쪽에 놓습니다. stones = [-22].
- 둘의 점수 차이는 (-22) - 0 = -22 입니다.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == stones.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= stones[i] &lt;= 10<sup>4</sup></code></li>
</ul></div>
