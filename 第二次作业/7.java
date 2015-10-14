public class Solution {
    public int reverse(int x) {
        double y = 0; //存储和计算反置的x
        while (x != 0)
        {
            y = y * 10 + (x % 10);
            x = x / 10;
        }
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
            return 0;
        return (int) y;    
    }
}