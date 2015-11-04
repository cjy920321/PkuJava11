public class Solution {
    public int climbStairs(int n) {
        int first = 0, second = 1;
        for (int i = 0; i < n; i ++)
        {
            second += first;
            first = second - first;
        }
        return second;
    }
}