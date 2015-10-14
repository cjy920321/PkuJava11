public class Solution {
    public boolean isUgly(int num) {
     	if(num==0)
		{
		  return false;
		}	
		while(num%2==0)//除去因子
		{
			num=num/2;
		}
		while(num%3==0)//除去因子
		{
			num=num/3;
		}			
		while(num%5==0)//除去因子
		{
			num=num/5;
		}
		if(num==1)//符合要求
		{				
			return true;
		}
		else
		{
			return false;
		}
    }
}