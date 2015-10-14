public class Solution {
    public int reverse(int x) {
     boolean sign=true;//正负标记
		boolean error=false;//溢出标记
		if(x==-2147483648)//最小值
		{
			return 0;
		}
		else if(x<0)//转换成正数
		{
			x=-x;
			sign=false;
		}
		String str=String.valueOf(x);//字符串化
		char []value=str.toCharArray();
		int n=value.length;
		for(int i=0;i<n/2;i++)
		{
			char j=value[i];
			value[i]=value[n-i-1];
			value[n-i-1]=j;
		}
		String maxsize=String.valueOf(Integer.MAX_VALUE);
		str="";
		if(n==maxsize.length())//是否超过最大值
		{
			for(int i=0;i<n;i++)
			{
				if(value[i]<maxsize.charAt(i))
				{
					break;
				}
				else if(value[i]>maxsize.charAt(i))
				{
					error=true;
					break;
				}
			}
		}
		if(error)
		{
			return 0;
		}
		else
		{
			for(int i=0;i<n;i++)
			{
				str+=value[i];
			}
		}
		int result=0;	
		if(sign)
		{
			return Integer.parseInt(str);
		}
		else
		{
			return -Integer.parseInt(str);
		}	
    }
}