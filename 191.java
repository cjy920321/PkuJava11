public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
      int count =0;
    for(int i =0; i< 32; i++){ //���32λ
        if((n & 1) == 1){ //��1���������㣬��ĩλ�Ƿ�=1
            count++;
        }
        n >>>= 1;//�޷��ŵ����ƶ�һλ
    }
    return count;
    }
}