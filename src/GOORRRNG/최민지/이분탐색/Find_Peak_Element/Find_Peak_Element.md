<h2><a href="https://leetcode.com/problems/find-peak-element/">162. Find Peak Element</a></h2><h3>Medium - Binary Search</h3><hr><div><p>A peak element는 양 옆의 element보다  큰 element를 말한다.</p>

<p><strong>0-indexed</strong> 정수 배열 <code>nums</code>가 주어질 때, peek element를 찾아 그 인덱스를 반환한다.배열에 peek element가 여러 개일 경우,<strong>어떠한 peek든</strong> 반환할 수 있다.</p>

<p><code>nums[-1] = nums[n] = -∞</code>라고 생각할 수 있다. 즉, 배열의 양 끝을 벗어난 이웃 요소가 항상 해당 배열 요소보다 무조건 작다.</p>

<p><code>O(log n)</code> 시간 내에 실행되는 알고리즘을 작성해야 한다.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 3 is a peak element and your function should return the index number 2.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,1,3,5,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>nums[i] != nums[i + 1]</code> for all valid <code>i</code>.</li>
</ul>
</div>
