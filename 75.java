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
		
		int red=0;//�������ֵ
		int white=0;
		int blue=0;
		for(int i=0;i<nums.length;i++)//����������ͬ���ֽ��м���
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
		for(int i=0;i<nums.length;i++)//���ݼ���������и�ֵ
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
	//ʱ�临�Ӷ�O(n)
}

