public class Solution {
    public String intToRoman(int num) {
        String[] roman = {"I", "V", "X", "L", "C", "D", "M"};     //罗马数字数组
        int[] value = {1, 5, 10, 50, 100, 500, 1000};         //对应数字大小
        int count = roman.length - 1, sign = 0;
        String ans = "";
        while(num > 0)
        {
            int quotient = num / value[count];
            if (quotient == 4)
            {
                if (sign == count + 1)
                {
                    ans = ans.substring(0,ans.length()-1) + roman[count] + roman[count + 2];
                    num -= quotient * value[count];
                    sign = 0;
                }
                else
                {
                    ans =  ans + roman[count] + roman[count + 1];
                    num -= quotient * value[count];
                }
            }
            else if(quotient > 0)
            {
                for (int i = 0; i < quotient; i++)
                {
                    ans = ans + roman[count];
                    num -= value[count];
                }
            sign = count;
            }
            count--;
        }
        return ans;
    }
}