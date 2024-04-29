<h2><a href="https://leetcode.com/problems/combination-sum-iii/">216. Combination Sum III</a></h2><h3>Medium - DFS, Backtracking</h3><hr><div><p>다음의 조건이 참인, 합이 <code>n</code>이 되는 <code>k</code>개의 숫자로 이루어진 유효한 조합을 찾는다.</p>

<ul>
	<li>숫자 <code>1</code> 부터 <code>9</code> 까지만 사용된다.</li>
	<li>각 숫자는 최대 <strong>한 번만</strong> 사용된다.</li>
</ul>

<p><em>가능한 모든 조합 리스트</em>를 반환한다. 리스트에는 동알한 조합이 두 번 포함되지 않아야 하며, 조합은 어떤 순서로든 반환될 수 있다.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> k = 3, n = 7
<strong>Output:</strong> [[1,2,4]]
<strong>Explanation:</strong>
1 + 2 + 4 = 7
There are no other valid combinations.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> k = 3, n = 9
<strong>Output:</strong> [[1,2,6],[1,3,5],[2,3,4]]
<strong>Explanation:</strong>
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> k = 4, n = 1
<strong>Output:</strong> []
<strong>Explanation:</strong> There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 &gt; 1, there are no valid combination.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= k &lt;= 9</code></li>
	<li><code>1 &lt;= n &lt;= 60</code></li>
</ul>
</div>
