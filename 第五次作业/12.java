public class Solution {
    public String intToRoman(int num) {
        String roman[]={"M","D","C","L","X","V","I"};
		int romanvalue[]={1000,500,100,50,10,5,1};
		String result="";
		for(int i=0;i<7;i++)
		{
			if(num>=romanvalue[i] && (i&1)==1)
			{
				num-=romanvalue[i];
				result=result+roman[i];
				continue;
			}
			else
			{
				while(num>=romanvalue[i])
				{
					num-=romanvalue[i];
					result=result+roman[i];
				}
				if(i<6)
				{
				int flag=(i&1)^1;
					if( num+romanvalue[i+1+flag]>=romanvalue[i])
					{
						num+=romanvalue[i+1+flag];
						num-=romanvalue[i];
						result=result+roman[i+1+flag]+roman[i];
					}
				}
			}
		}
		return result;
    }
}