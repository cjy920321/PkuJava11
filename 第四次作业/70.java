public class Solution {
	public int climbStairs(int n) {
	    if(n == 0 || n == 1 || n == 2)
	    {
	    	return n;
	    }
	    int[] count = new int[n];
	    count[0] = 1;
	    count[1] = 2;
	    for(int i = 2; i < n; i++){ //����ѭ����¼��ÿ����һ��̨�׿��еķ���
	        count[i] = count[i-1] + count[i-2];
	    }
	    return count[n-1];
}