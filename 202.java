public class Solution {
    public boolean isHappy(int n) {
        int a, sum = 0, m = n;  //a存n的一位，sum计算平方和，m存上一个n
        boolean[] sign = new boolean[200];  //用一数组标记经过运算出现过的数
        while (n >= 200 || (n < 200 && sign[n] == false))
        {
            m = n;
            sum = 0;
            while (n > 0)
            {
                a = n % 10;
                sum = sum + a * a;
                n = n / 10;
            }
            if (sum == 1)
                return true;
            n = sum;
            if (m < 200)
                sign[m] = true;
        }
        return false;
    }
}