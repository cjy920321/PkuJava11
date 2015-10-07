public class Solution {
    public int lengthOfLastWord(String s) {
        int length=s.length();
		char space=' ';
		int last_word_lengh=0;
		for (int i = length-1; i >=0; i--) { //从后往前找
			if(space==s.charAt(i))
			{
			 if(0!=last_word_lengh)//如果不是0，那么说明已经测出lastword长度了
				{
					break;
				
				}
				
				
			}
			else {
				 last_word_lengh++;
			}
			
		}
		return last_word_lengh;
    }
}