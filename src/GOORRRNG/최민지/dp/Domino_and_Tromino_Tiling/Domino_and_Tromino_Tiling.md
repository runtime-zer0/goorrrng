<h2><a href="https://leetcode.com/problems/domino-and-tromino-tiling/">790. Domino and Tromino Tiling</a></h2><h3>Medium - Dynamic Programming</h3><hr><div><p>두 가지 유형의 타일이 있다: <code>2 x 1</code> 도미노 모양과 트로미노 모양이 있다. 이 도형들은 회전할 수 있다.</p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/15/lc-domino.jpg" style="width: 362px; height: 195px;">
<p>정수 n이 주어졌을 때, <code>2 x n</code> <em>바둑판을 타일링 하는 방법의 수</em>를 반환한다. 답이 매우 클 수 있으므로, <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>을 반환한다.</p>

<p>타일링할 때는 모든 사각형이 타일로 덮여 있어야 한다. 두 개의 타일리은 보드에 4방향으로 인접한 두 개의 셀이 있고, 타일링 중 정확히 하나의 타일이 두 개의 사각형을 모두 차지하는 경우에만 서로 다른 타일링이다.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/15/lc-domino1.jpg" style="width: 500px; height: 226px;">
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> 5
<strong>Explanation:</strong> The five different ways are show above.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>
</div>
