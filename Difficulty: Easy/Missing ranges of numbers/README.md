<h2><a href="https://www.geeksforgeeks.org/problems/missing-ranges-of-numbers1019/1">Missing ranges of numbers</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an array <strong>arr</strong>. Find the missing elements ranges (if any) in the range <strong>0</strong> to <strong>max element</strong> of <strong>arr</strong>.&nbsp;</span><span style="font-size: 18px;">If </span><span style="font-size: 18px;">there is more than one missing, collate them using the hyphen (-) and separate each different range with a space</span><strong style="font-size: 18px;">.&nbsp;</strong><span style="font-size: 18px;">If there are no missing elements then return "</span><strong style="font-size: 18px;">-1</strong><span style="font-size: 18px;">".</span><br><br><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [62, 8, 34, 5, 332]
<strong>Output:</strong> 0-4 6-7 9-33 35-61 63-331
<strong>Explanation:</strong> Elements in the range 0-4, 6-7, 9-33, 35-61 and 63-331 are not present.
</span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [13, 0, 32, 500]
<strong>Output:</strong> 1-12 14-31 33-499
<strong>Explanation:</strong> Elements in the range 1-12, 14-31 and 33-499 are not present.
</span></pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong> O(n)<br><strong>Expected Auxiliary Space:</strong> O(n)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints</strong><br>1 &lt;= arr.size() &lt;= 10<sup>6</sup><br>0 &lt;= arr[i] &lt;= 10<sup>5</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;