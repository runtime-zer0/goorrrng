<h2><a href="https://leetcode.com/problems/basic-calculator//">224. Basic Caculator</a></h2><h3>Hard - Math, String, Stack, Recursion</h3><hr><div><p>유효한 식을 나타내는 문자열 <code>s</code>가 주어지면, 이를 계산하는 기본 계산기를 구현하고 <em>계산 결과를 반환합니다.</em>

<strong>참고:</strong> 문자열을 수학 표현식으로 계산하는 내장 함수(예: <code>eval()</code>)는 사용할 수 없습니다.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "1 + 1"
<strong>Output:</strong> 2</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = " 2-1 + 2 "
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "(1+(4+5+2)-3)+(6+8)"
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 <= s.length <= 3 * 10^5</code></li>
	<li><code>s</code> consists of digits, <code>'+'</code>, <code>'-'</code>, <code>'('</code>, <code>')'</code>, and <code>' '</code>.</li>
  <li><code>s</code> represents a valid expression.</li>
  <li><code>'+'</code> is <strong>not</strong> used as a unary operation (i.e., <code>"+1"</code> and <code>"+(2 + 3)"</code> is invalid).</li>
  <li><code>'-'</code> could be used as a unary operation (i.e., <code>"-1"</code> and <code>"-(2 + 3)"</code> is valid).</li>
  <li>There will be no two consecutive operators in the input.</li>
  <li>Every number and running calculation will fit in a signed 32-bit integer.</li>
</ul>
</div>
