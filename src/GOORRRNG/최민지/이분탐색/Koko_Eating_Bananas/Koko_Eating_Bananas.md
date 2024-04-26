<h2><a href="https://leetcode.com/problems/koko-eating-bananas/">875. Koko Eating Bananas</a></h2><h3>Medium</h3><hr><div>

코코는 바나나를 좋아합니다. `n`개의 바나나 더미가 있고, `i`번째 더미는 `piles[i]` 개의 바나나를 가지고 있어요. 경비병이 나갔고 `h`시간 후에 돌아올 거예요.

코코는 시간당 바나나 먹는 속도를 `k`로 정할 수 있으며, 매 시간마다 바나나 더미를 선택하고 그 더미에서 바나나를 `k`개씩 먹습니다. 바나나 더미에 바나나가 `k`개보다 적으면 코코는 바나나를 모두 먹고 이 시간 동안 더 이상 바나나를 먹지 않습니다.

코코는 천천히 먹는 것을 좋아하지만 경비원이 돌아오기 전에 바나나를 모두 먹고 싶어 합니다.

코코가 `h` 시간 안에 바나나를 모두 먹을 수 있는 최소 정수 `k`를 반환합니다.

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> piles = [3,6,7,11], h = 8
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> piles = [30,11,23,4,20], h = 5
<strong>Output:</strong> 30
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> piles = [30,11,23,4,20], h = 6
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
	<li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div>
