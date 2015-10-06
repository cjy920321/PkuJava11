class Solution{
	public void sortColors(int[] nums)
	{
//		int n=nums.length;
//		for(int i=0;i<n;i++)
//		{
//			for(int j=n-1;j>i;j--)
//			{
//				if(nums[j]<nums[j-1])
//				{
//					int value=nums[j-1];
//					nums[j-1]=nums[j];
//					nums[j]=value;
//				}
//			}
//		}
		
		int red=0;//定义计数值
		int white=0;
		int blue=0;
		for(int i=0;i<nums.length;i++)//对数组中相同数字进行计数
		{
			if(nums[i]==0)
			{
				++red;
			}
			else if(nums[i]==1)
			{
				++white;
			}
			else
			{
				++blue;
			}
				
		}
		for(int i=0;i<nums.length;i++)//根据计数结果进行赋值
		{
			if(i<red)
			{
				nums[i]=0;
			}
			else if(i<red+white)
			{
				nums[i]=1;
			}
			else
			{
				nums[i]=2;
			}
		}
		
	}
	//时间复杂度O(n)
}

