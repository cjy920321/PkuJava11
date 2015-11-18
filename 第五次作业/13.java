public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romans=new HashMap<Character, Integer>();
		romans.put('M', 1000);
		romans.put('D', 500);
		romans.put('C', 100);
		romans.put('L', 50);
		romans.put('X', 10);
		romans.put('V', 5);
		romans.put('I', 1);
		
		int result=0;
		
		int accumulation=0;
		char cc[]=s.toCharArray();
		int last=romans.get(cc[0]);
		for(int i=0;i<cc.length;i++)
		{
			int cur=romans.get(cc[i]);
//				if(cur==last)
//				{
//					accumulation+=accumulation;
//					
//				}

			
			if(cur>last)
			{
				result-=accumulation;
				accumulation=0;
			}
			
			if(cur<last)
			{
				result+=accumulation;
				accumulation=0;
			}
			accumulation+=cur;
			last=cur;
			
		}
		result+=accumulation;
		return result;
    }
}