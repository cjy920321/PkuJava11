ublic class Solution {
    public int addDigits(int num) {
        int result;
		while(true)
		{
			result=0;
		while((num/10)!=0)//按位相加
		{
			result+=(num%10);
			num=num/10;
		}
		result+=num;
		if(result<10)//如果是个位数跳出循环
		{
			break;
		}
		else
		{
			num=result;
		}
		
		}
		
		return result;
    }
}