<h2><a href="https://leetcode.com/problems/total-cost-to-hire-k-workers/">2462. Total Cost to Hire K Workers</a></h2><h3>Medium - Heap(Priority Queue), Simulation</h3><hr><div><p> <strong>0-indexed</strong> 정수 배열<code>costs</code> 가 주어지고, <code>costs[i]</code>는 <code>i<sup>th</sup></code> 작업자를 고르는 데 드는 비용이다.</p>

<p>또한 두 개의 정수 <code>k</code>와 <code>candidates</code>이 주어진다. 다음 규칙에 따라 정확히 <code>k</code>명의 작업자를 고용하고자 한다:</p>

<ul>
	<li><code>k</code>번의 세션을 진행하고, 각 세션에서 정확히 한 명의 작업자를 고용한다.</li>
	<li>각 채용 세션에서 첫 번째 <code>candidates</code> 근로자 또는 마지막 <code>candidates</code> 근로자 중에서 가장 낮은 비용을 가진 근로자를 선택한다. 비용이 같을 경우에는 더 작은 인덱스의 근로자를 선택한다.
	<ul>
		<li>예를 들어, 만약 <code>costs = [3,2,7,7,1,2]</code> 이고 <code>candidates = 2</code> 라면, 첫 번째 채용 세션에서, <code>4<sup>th</sup></code> 작업자를 고를 것이다. 그 이유는, 다음 후보들 중에서 가장 낮은 비용을 가지기 때문이다 <code>[<u>3,2</u>,7,7,<u><strong>1</strong>,2</u>]</code>.</li>
		<li>두 번째 채용 세션에서 <code>1<sup>st</sup></code> 작업자를 고를 것이다. 그 이유는,  <code>4<sup>th</sup></code> 작업자와 같은 비용이지만 더 작은 인덱스에 위치해 있기 때문이다 <code>[<u>3,<strong>2</strong></u>,7,<u>7,2</u>]</code>. 이 과정에서 인덱싱이 변경될 수 있음을 유의하라.</li>
	</ul>
	</li>
	<li>남은 후보 작업자가 적은 경우, 그 중에서 비용이 가장 적은 작업자를 선텍한다. 마찬가지로 비용이 같은 경우에는 더 작은 인덱스의 근로자를 선택한다.</li>
	<li>작업자는 한 번만 선택할 수 있다.</li>
</ul>

<p><code>k</code>명의 근로자를 고용하는 데에 드는 <em>총 비용 </em>을 반환하라.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
<strong>Output:</strong> 11
<strong>Explanation:</strong> We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [<u>17,12,10,2</u>,7,<u>2,11,20,8</u>]. The lowest cost is 2, and we break the tie by the smallest index, which is 3. The total cost = 0 + 2 = 2.
- In the second hiring round we choose the worker from [<u>17,12,10,7</u>,<u>2,11,20,8</u>]. The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
- In the third hiring round we choose the worker from [<u>17,12,10,7,11,20,8</u>]. The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. Notice that the worker with index 3 was common in the first and last four workers.
The total hiring cost is 11.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> costs = [1,2,4,1], k = 3, candidates = 3
<strong>Output:</strong> 4
<strong>Explanation:</strong> We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [<u>1,2,4,1</u>]. The lowest cost is 1, and we break the tie by the smallest index, which is 0. The total cost = 0 + 1 = 1. Notice that workers with index 1 and 2 are common in the first and last 3 workers.
- In the second hiring round we choose the worker from [<u>2,4,1</u>]. The lowest cost is 1 (index 2). The total cost = 1 + 1 = 2.
- In the third hiring round there are less than three candidates. We choose the worker from the remaining workers [<u>2,4</u>]. The lowest cost is 2 (index 0). The total cost = 2 + 2 = 4.
The total hiring cost is 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= costs.length &lt;= 10<sup>5 </sup></code></li>
	<li><code>1 &lt;= costs[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k, candidates &lt;= costs.length</code></li>
</ul>
</div>
