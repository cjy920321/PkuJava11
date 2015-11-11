public class Solution {
    public String intToRoman(int num) {
        	String s="";
		int first=num%10;
		int second=(num/10)%10;
		int third=(num/100)%10;
		int four=num/1000;
	    for(int i=0;i<four;i++){
	    	s+="M";
	    }
		if(third!=0){
			if(third<4){
				for(int i=0;i<third;i++){
					s+="C";
				}
			}
			else if(third==4){
				s+="CD";
			}
			else if(third<9){
				s+="D";
				for(int i=0;i<third-5;i++){
					s+="C";
				}
			}
			else{
				s+="CM";
			}
		}
		if(second!=0){
			if(second<4){
				for(int i=0;i<second;i++){
					s+="X";
				}
			}
			else if(second==4){
				s+="XL";
			}
			else if(second<9){
				s+="L";
				for(int i=0;i<second-5;i++){
					s+="X";
				}
			}
			else{
				s+="XC";
			}
		}
		if(first!=0){
			if(first<4){
				for(int i=0;i<first;i++){
					s+="I";
				}
			}
			else if(first==4){
				s+="IV";
			}
			else if(first<9){
				s+="V";
				for(int i=0;i<first-5;i++){
					s+="I";
				}
			}
			else{
				s+="IX";
			}
		}
		
		return s;
    }
}