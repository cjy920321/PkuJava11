public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        else
            return ((n&(n - 1)) == 0);
    }
}