<h2><a href="https://practice.geeksforgeeks.org/problems/rearrange-array-such-that-even-positioned-are-greater-than-odd4804/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab">Rearrange array such that even positioned are greater than odd</a></h2><h3>Difficulty Level : Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an array A of n elements, rearrange the array according to the following relations :<br>A[i] &gt;= A[i-1], if i is even.<br>A[i] &lt;= A[i-1], if i is odd.[Considering 1-indexed array]<br>Return the resultant array.</span></p>
<pre><span style="font-size: 18px;"><strong>Example:</strong>

<strong>Input 1:
A[] = {</strong>1, 2, 2, 1}<strong>
Output:
</strong>1 2 1 2<strong>
Explanation:</strong>
Both 2 are at even positions and 1 at odd satisfying 
given condition <strong>

Input 2:
A[] = {</strong>1, 3, 2}
<strong>Output:
</strong>1 3 2
<strong>Explanation:</strong>
Here, the array is already sorted as per the conditions.</span></pre>
<p>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Your Task:</strong><br>This is a function problem. The input is already taken care of by the driver code. You only need to complete the function <strong>assign()</strong> that takes an array <strong>(arr)</strong>, sizeOfArray <strong>(n)</strong>, and return the resultant array.<br><strong>Note</strong>:&nbsp;Generated output will depict whether your returned answer is correct or wrong</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong>&nbsp;O(NLOG(N)).<br><strong>Expected Auxiliary Space:</strong>&nbsp;O(1).</span></p>
<p><br><span style="font-size: 18px;"><strong>Constraints:</strong></span></p>
<p><span style="font-size: 18px;">1 ≤ N ≤ 10<sup>5</sup></span><br><span style="font-size: 18px;">1 ≤ arr[i] ≤ 10<sup>6</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Sorting</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;