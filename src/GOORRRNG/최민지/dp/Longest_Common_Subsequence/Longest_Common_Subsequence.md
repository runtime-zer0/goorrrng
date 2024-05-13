<h2><a href="https://leetcode.com/problems/longest-common-subsequence/">1143. Longest Common Subsequence</a></h2><h3>Medium - Dynamic Programming</h3><hr><div><p>두 개의 문자열 <code>text1</code>과 <code>text2</code>이 주어질 때, <em>가장 긴 <strong>공통 부분 문자열의</strong> 길이를 반환하라. </em>만약 <strong>공통 부분 문자열</strong>이 없다면, <code>0</code>을 반환하라.</p>

<p>문자열의 <strong>부분 문자열</strong>은 나머지 문자의 순서를 바꾸지 않고 일부 문자(없을 수도 있음)를 삭제하여 원래의 문자열로부터
생성된 새로운 문자열이다.</p>

<ul>
	<li>예를 들어, <code>"ace"</code> 는 <code>"abcde"</code>의 부분 문자열이다.</li>
</ul>

<p>두 문자열의 <strong>공통 부분 문자열</strong>은 두 문자열에 공통적으로 적용되는 부분 문자열이다.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> text1 = "abcde", text2 = "ace" 
<strong>Output:</strong> 3  
<strong>Explanation:</strong> The longest common subsequence is "ace" and its length is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> text1 = "abc", text2 = "abc"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The longest common subsequence is "abc" and its length is 3.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> text1 = "abc", text2 = "def"
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no such common subsequence, so the result is 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= text1.length, text2.length &lt;= 1000</code></li>
	<li><code>text1</code> and <code>text2</code> consist of only lowercase English characters.</li>
</ul>
</div>
