public class Solution {
    public boolean isPalindrome(String s) {
       s=s.trim();//去掉空格
		if(s.equals(""))//空字符串认为是回文
		{
			return true;
		}
		int n=s.length();
		boolean sign=true;
		int i=0;
		int j=s.length()-1;
		char value1=' ';
		char value2=' ';
		while(i!=j)
		{
			while(i<s.length()&&!((s.charAt(i)>=65&&s.charAt(i)<=90)||(s.charAt(i)>=97&&s.charAt(i)<=122)||(s.charAt(i)>=48&&s.charAt(i)<=57)))
			{
				++i;
			}//从前往后找到字母
			while(j>=0&&!((s.charAt(j)>=65&&s.charAt(j)<=90)||(s.charAt(j)>=97&&s.charAt(j)<=122)||(s.charAt(j)>=48&&s.charAt(j)<=57)))
			{
				--j;
			}//从后往前找到字母
			if(i==s.length()||j==-1)
			{
			    return true;
			}
			if(i==j)//相等时跳出循环
			{
				break;
			}
			if(s.charAt(i)>=65&&s.charAt(i)<=90)//大写转换成小写
			{
				value1=(char)(s.charAt(i)+32);
			}
			else
			{
				value1=s.charAt(i);
			}
			if(s.charAt(j)>=65&&s.charAt(j)<=90)//大写转换成小写
			{
				value2=(char)(s.charAt(j)+32);
			}
			else
			{
				value2=s.charAt(j);
			}
			if(value1==value2)//相等时继续循环
			{
				++i;
				--j;
			}
			else//不相等时跳出循环
			{
				sign=false;
				break;
			}
		}
		return sign;//返回
		
    }
}