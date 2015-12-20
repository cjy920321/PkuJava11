public class Solution {
 public int trailingZeroes(int n){
          int s=0;
            int m=n;
            while(m>=5){
            	m=m/5;
            	s=s+m;
            }
            return s;
    }
}