class Solution{
	public String addBinary(String a,String b)
	{
		String value="";
		if(a.length()<b.length())//确定a比b长
		{
			value=b;
			b=a;
			a=value;
		}
		char []a1=a.toCharArray();//数组化
		char []b1=b.toCharArray();//数组化
		char carry='0';//进位初始化
		value="";
		int n=a1.length-b1.length;
		for(int i=a1.length-1;i>=n;i--)//从每一位进行加法
		{
			if(a1[i]=='1'&&b1[i-n]=='1')
			{
				if(carry=='0')
				{
					a1[i]='0';
				}
				carry='1';
			}
			else if(a1[i]=='0'&&b1[i-n]=='0')
			{
				a1[i]=carry;
				carry='0';
			}
			else
			{
				if(carry=='1')
				{
					a1[i]='0';
				}
				else
				{
					a1[i]='1';
				}
			}
		}
		if(carry=='1')//a比b长的那一段对进位的处理
		{
			int i=n-1;
			while(i>=0&&a1[i]=='1')
			{
				a1[i]='0';
				--i;
			}
			if(i!=-1)
			{
				a1[i]='1';
			}
			else
			{
				value="1";
			}	
		}
		for(int i=0;i<a1.length;i++)//输出字符串赋值
		{
			value+=a1[i];
		}
		return value;//返回
		
		//时间复杂度O(n)
		
		
		
	}		
}