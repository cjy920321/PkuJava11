class Solution{
	public String reverseWords(String s)
	{
		s=s.trim();//ȥ���ո�
		int n=s.length();
		if(n==0)
		{
			return ""; 
		}	
		String str[]=s.split(" ");//�����Ӳ�ֳɴ���
		n=str.length;
		s=str[n-1];
		for(int i=n-2;i>=0;i--)//��s�������¸�ֵ
		{
			if(!str[i].equals(""))
			{
				s=s+" "+str[i];
			}
		}
		return s;
	}
	//ʱ�临�Ӷ�O(n)
}