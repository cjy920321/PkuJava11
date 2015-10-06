class Solution{
	public int myAtoi(String str)
	{
		int result=0;//构造int值
		int i=0;//用来标记字符串的位置
		int j=0;//用来标记字符串的的位置
		int sign=0;//用来比较大小的标记量
		String maxsize=String.valueOf(Integer.MAX_VALUE);//int最大值
		String minsize=String.valueOf(Integer.MIN_VALUE);//int最小值
		if(str.equals(""))//如果字符串为空
		{
			return 0;
		}
		for(j=0;j<str.length();j++)//去掉开始的空格
		{
			if(str.charAt(j)!=' ')
			{
				break;
			}
		}
		str=str.substring(j);
		char []a=str.toCharArray();//将字符串数组化
		if(a[0]==43||a[0]==45)//如果最先的字符是+-号
		{
			i=1;
		    while(i<a.length&&a[i]>=48&&a[i]<=57)//判断有多少连续的数字
		    {
		    	++i;
		    }
		    if(i==1)//没有数字
		    {
		    	return 0;
		    }
		    str="";//初始化
		    for(j=1;j<i;j++)//将连续的数字存入字符串
		    {
		    	str+=a[j];
		    }
		    if(a[0]==43)//如果为正数
		    {
		    	if(i-1<maxsize.length())//在int范围内
		    	{
		    		result=Integer.parseInt(str);
		    	}
		    	else if(i-1==maxsize.length())//与最大值位数相同
		    	{
		    		for(j=1;j<i;j++)//判断是否超过最大值
		    		{
		    		   if(a[j]<maxsize.charAt(j-1))
		    		   {
		    				break;
		    		   }
		    		   if(a[j]>maxsize.charAt(j-1))
		    		   {
		    			   sign=1;
		    			   break;
		    		   }
		    		}
		    		if(sign==1)//超过最大值的情况
		    		{
		    			return Integer.MAX_VALUE;
		    		}
		    		else//未超过最大值的情况
		    		{
		    			
		    			result=Integer.parseInt(str);
		    		}
		    	}
		    	else//超过int最大值
		    	{
		    		return Integer.MAX_VALUE;
		    	}	
		    }
		    else//如果为负数
		    {
		    	if(i<minsize.length())//在int范围内
		    	{
		    		result=Integer.parseInt(str);
		    		result=-result;
		    	}
		    	else if(i==minsize.length())//与最小值位数相同
		    	{
		    		for(j=1;j<i;j++)//判断是否小于最小值
		    		{
		    			if(a[j]<minsize.charAt(j))
		    			{
		    				break;
		    			}
		    		   if(a[j]>minsize.charAt(j))
		    		   {
		    			   sign=1;
		    			   break;
		    		   }
		    		}
		    		if(sign==1)//超出int范围
		    		{
		    			return Integer.MIN_VALUE;
		    		}
		    		else//在int范围内
		    		{
		    			if(str.equals("2147483648"))//是最小值的情况
		    			{
		    				result=Integer.parseInt(minsize);
		    			}
		    			else
		    			{
		    			result=Integer.parseInt(str);
		    			result=-result;
		    			}
		    		}
		    	}
		    	else//超出int范围
		    	{
		    		return Integer.MIN_VALUE;
		    	}	
		    }
		}
		else if(a[0]<48||a[0]>57)//最先字符不是数字或+-号
		{
			return 0;
		}
		else//最先字符是数字的情况
		{
		    while(i<a.length&&a[i]>=48&&a[i]<=57)//判断有多少连续数字
		    {
		    	++i;
		    }
		    str="";
		    for(j=0;j<i;j++)//将连续数字转换为字符串
		    {
		    	str+=a[j];
		    }
		    if(i<maxsize.length())//判断是否超过最大值
		    {
		    	result=Integer.parseInt(str);
		    }
		    else if(i==maxsize.length())//与最大值位数相同的情况
		    {
		    	for(j=0;j<i;j++)//判断是否超过int范围
		    	{
		    		if(a[j]<maxsize.charAt(j))
		    		{
		    			break;
		    		}
		    		if(a[j]>maxsize.charAt(j))
		    		{
		    			sign=1;
		    			break;
		    		}
		    	}
		    	if(sign==1)//超过int范围的情况
		    	{
		    		return Integer.MAX_VALUE;
		    	}
		    	else//在int范围内的情况
		    	{
		    		result=Integer.parseInt(str);
		    	}
		    }
		    else//超过int范围的情况
		    {
		    	return Integer.MAX_VALUE;
		    }
		}
		return result;//返回int值
		}
	//时间复杂度O(n)
}