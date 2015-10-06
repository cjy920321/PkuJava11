class Solution{
	public String reverseWords(String s)
	{
		s=s.trim();//去掉空格
		int n=s.length();
		if(n==0)
		{
			return ""; 
		}	
		String str[]=s.split(" ");//将句子拆分成词语
		n=str.length;
		s=str[n-1];
		for(int i=n-2;i>=0;i--)//对s进行重新赋值
		{
			if(!str[i].equals(""))
			{
				s=s+" "+str[i];
			}
		}
		return s;
	}
	//时间复杂度O(n)
}