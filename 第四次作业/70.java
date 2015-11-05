public class Solution {
	public int climbStairs(int n) {
	    if(n == 0 || n == 1 || n == 2)
	    {
	    	return n;
	    }
	    int[] count = new int[n];
	    count[0] = 1;
	    count[1] = 2;
	    for(int i = 2; i < n; i++){ //依次循环记录出每增加一个台阶可行的方案
	        count[i] = count[i-1] + count[i-2];
	    }
	    return count[n-1];
}