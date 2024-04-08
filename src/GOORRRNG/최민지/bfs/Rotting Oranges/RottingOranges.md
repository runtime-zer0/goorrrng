<h2><a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a></h2><h3>Medium</h3><hr><div><p>You are given an <code>m x n</code> <code>grid</code> where each cell can have one of three values:</p>

<ul>
	<li><code>0</code> representing an empty cell,</li>
	<li><code>1</code> representing a fresh orange, or</li>
	<li><code>2</code> representing a rotten orange.</li>
</ul>

<p>Every minute, any fresh orange that is <strong>4-directionally adjacent</strong> to a rotten orange becomes rotten.</p>

<p>Return <em>the minimum number of minutes that must elapse until no cell has a fresh orange</em>. If <em>this is impossible, return</em> <code>-1</code>.</p>

<br>
<hr>
<p>각 셀이 세 가지 값 중 하나를 가질 수 있는 <code>m x n</code> <code>grid</code> 가 주어집니다:</p>
<ul>
	<li><code>0</code> 빈 셀을 나타냅니다,</li>
	<li><code>1</code> 신선한 오렌지를 나타내거나</li>
	<li><code>2</code> 썩은 오렌지를 나타냅니다.</li>
</ul>

<p>썩은 오렌지와 <strong>4방향으로 인접한</strong> 신선한 오렌지는 1분마다 썩게 됩니다.</p>

<p><em>신선한 오렌지가 있는 셀이 모두 없어질 때까지 경과되는 최소 시간</em> 을 반환합니다. <em>불가능하다면, </em> <code>-1</code>을 반환합니다.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/02/16/oranges.png" style="width: 650px; height: 137px;">
<pre><strong>Input:</strong> grid = [[2,1,1],[1,1,0],[0,1,1]]
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[2,1,1],[0,1,1],[1,0,1]]
<strong>Output:</strong> -1
<strong>Explanation:</strong> The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> grid = [[0,2]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> Since there are already no fresh oranges at minute 0, the answer is just 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10</code></li>
	<li><code>grid[i][j]</code> is <code>0</code>, <code>1</code>, or <code>2</code>.</li>
</ul>
</div>
