class Solution{
	public String addBinary(String a,String b)
	{
		String value="";
		if(a.length()<b.length())//ȷ��a��b��
		{
			value=b;
			b=a;
			a=value;
		}
		char []a1=a.toCharArray();//���黯
		char []b1=b.toCharArray();//���黯
		char carry='0';//��λ��ʼ��
		value="";
		int n=a1.length-b1.length;
		for(int i=a1.length-1;i>=n;i--)//��ÿһλ���мӷ�
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
		if(carry=='1')//a��b������һ�ζԽ�λ�Ĵ���
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
		for(int i=0;i<a1.length;i++)//����ַ�����ֵ
		{
			value+=a1[i];
		}
		return value;//����
		
		//ʱ�临�Ӷ�O(n)
		
		
		
	}		
}