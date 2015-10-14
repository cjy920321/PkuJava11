public class Solution {
    public int singleNumber(int[] nums) {
        long result1=0;
		long result2=0;
		for(int i=0;i<nums.length;i++)//判断相同元素的序号并相加
		{
			for(int j=i+1;j<nums.length;j++)
			{
				if(nums[i]-nums[j]==0)
				{
					result1=result1+i+j;
				}
			}
		}
		for(int i=0;i<nums.length;i++)//序号相加
		{
			result2+=i;
		}
		int result=(int)(result2-result1);//找到所找数的序号
		
		
		
		return nums[result];//返回
    }
}