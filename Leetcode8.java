class Solution{
	public int myAtoi(String str)
	{
		int result=0;//����intֵ
		int i=0;//��������ַ�����λ��
		int j=0;//��������ַ����ĵ�λ��
		int sign=0;//�����Ƚϴ�С�ı����
		String maxsize=String.valueOf(Integer.MAX_VALUE);//int���ֵ
		String minsize=String.valueOf(Integer.MIN_VALUE);//int��Сֵ
		if(str.equals(""))//����ַ���Ϊ��
		{
			return 0;
		}
		for(j=0;j<str.length();j++)//ȥ����ʼ�Ŀո�
		{
			if(str.charAt(j)!=' ')
			{
				break;
			}
		}
		str=str.substring(j);
		char []a=str.toCharArray();//���ַ������黯
		if(a[0]==43||a[0]==45)//������ȵ��ַ���+-��
		{
			i=1;
		    while(i<a.length&&a[i]>=48&&a[i]<=57)//�ж��ж�������������
		    {
		    	++i;
		    }
		    if(i==1)//û������
		    {
		    	return 0;
		    }
		    str="";//��ʼ��
		    for(j=1;j<i;j++)//�����������ִ����ַ���
		    {
		    	str+=a[j];
		    }
		    if(a[0]==43)//���Ϊ����
		    {
		    	if(i-1<maxsize.length())//��int��Χ��
		    	{
		    		result=Integer.parseInt(str);
		    	}
		    	else if(i-1==maxsize.length())//�����ֵλ����ͬ
		    	{
		    		for(j=1;j<i;j++)//�ж��Ƿ񳬹����ֵ
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
		    		if(sign==1)//�������ֵ�����
		    		{
		    			return Integer.MAX_VALUE;
		    		}
		    		else//δ�������ֵ�����
		    		{
		    			
		    			result=Integer.parseInt(str);
		    		}
		    	}
		    	else//����int���ֵ
		    	{
		    		return Integer.MAX_VALUE;
		    	}	
		    }
		    else//���Ϊ����
		    {
		    	if(i<minsize.length())//��int��Χ��
		    	{
		    		result=Integer.parseInt(str);
		    		result=-result;
		    	}
		    	else if(i==minsize.length())//����Сֵλ����ͬ
		    	{
		    		for(j=1;j<i;j++)//�ж��Ƿ�С����Сֵ
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
		    		if(sign==1)//����int��Χ
		    		{
		    			return Integer.MIN_VALUE;
		    		}
		    		else//��int��Χ��
		    		{
		    			if(str.equals("2147483648"))//����Сֵ�����
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
		    	else//����int��Χ
		    	{
		    		return Integer.MIN_VALUE;
		    	}	
		    }
		}
		else if(a[0]<48||a[0]>57)//�����ַ��������ֻ�+-��
		{
			return 0;
		}
		else//�����ַ������ֵ����
		{
		    while(i<a.length&&a[i]>=48&&a[i]<=57)//�ж��ж�����������
		    {
		    	++i;
		    }
		    str="";
		    for(j=0;j<i;j++)//����������ת��Ϊ�ַ���
		    {
		    	str+=a[j];
		    }
		    if(i<maxsize.length())//�ж��Ƿ񳬹����ֵ
		    {
		    	result=Integer.parseInt(str);
		    }
		    else if(i==maxsize.length())//�����ֵλ����ͬ�����
		    {
		    	for(j=0;j<i;j++)//�ж��Ƿ񳬹�int��Χ
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
		    	if(sign==1)//����int��Χ�����
		    	{
		    		return Integer.MAX_VALUE;
		    	}
		    	else//��int��Χ�ڵ����
		    	{
		    		result=Integer.parseInt(str);
		    	}
		    }
		    else//����int��Χ�����
		    {
		    	return Integer.MAX_VALUE;
		    }
		}
		return result;//����intֵ
		}
	//ʱ�临�Ӷ�O(n)
}