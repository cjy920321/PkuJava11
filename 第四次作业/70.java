public class Solution {
    public int climbStairs(int n) {
        	int f1=1;//f(n-2)
		int f2=2;//f(n-1)
		int f3=1;
		if(n==1){//前两层的情况
			return 1;
		}
		if(n==2){
			return 2;
		}
		for(int i=3;i<=n;i++){//f(n)=f(n-1)+f(n-2)
			f3=f1+f2;
			f1=f2;
			f2=f3;
		}
		return f3;
    }
}