public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
      int count =0;
    for(int i =0; i< 32; i++){ //最多32位
        if((n & 1) == 1){ //和1进行与运算，看末位是否=1
            count++;
        }
        n >>>= 1;//无符号的右移动一位
    }
    return count;
    }
}