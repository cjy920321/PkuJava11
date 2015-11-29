public class Solution {
    public int titleToNumber(String s) {
        if(s.length()==0){
			return 0;
		}
		int result=0;
		int n=s.length();
		for(int i=n-1;i>=0;i--){
			result=result+((int)s.charAt(i)-64)*(int)Math.pow(26,n-1-i);
		}
		return result;
    }
}