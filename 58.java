public class Solution {
    public int lengthOfLastWord(String s) {
        int length=s.length();
		char space=' ';
		int last_word_lengh=0;
		for (int i = length-1; i >=0; i--) { //�Ӻ���ǰ��
			if(space==s.charAt(i))
			{
			 if(0!=last_word_lengh)//�������0����ô˵���Ѿ����lastword������
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