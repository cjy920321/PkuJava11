public class Solution {
    public int romanToInt(String s) {
        int num=0;
		int i=0;
	    int j=0;
	    if(s.equals("")){
	    	return 0;
	    }
	    if(i<s.length()&&s.charAt(i)=='M'){
	    	while(j<s.length()-1&&s.charAt(j+1)=='M'){
	    		++j;
	    	}
	    	num=(j-i+1)*1000;
	   		i=j+1;
	   		++j;
	   	}
	   	if(i<s.length()&&s.charAt(i)=='C'){
    		if(j<s.length()-1&&s.charAt(j+1)=='M'){
    			num+=900;
    			++j;
    			i=j+1;
    			++j;
    		}
    		else if(j<s.length()-1&&s.charAt(j+1)=='D'){
    			num+=400;
    			++j;
    			i=j+1;
    			++j;
    		}
    		else if(j<s.length()-1&&s.charAt(j+1)=='C'){
    			++j;
	    		if(j<s.length()-1&&s.charAt(j+1)=='C'){
	    			++j;
	    		}
	    		num=num+((j-i+1)*100);
	    		i=j+1;
	    		++j;
	   		}
    		else{
    			num+=100;
    			++i;
    			++j;
    		}
	   	}
	    if(i<s.length()&&s.charAt(i)=='D'){
	    	while(j<s.length()-1&&s.charAt(j+1)=='C'){
	    		++j;
	    	}
	    	num=num+500+((j-i)*100);
	    	i=j+1;
	    	++j;
	    }
		if(i<s.length()&&s.charAt(i)=='X'){
			if(j<s.length()-1&&s.charAt(j+1)=='C'){
				num+=90;
				++j;
				i=j+1;
				++j;
			}
			else if(j<s.length()-1&&s.charAt(j+1)=='L'){
				num+=40;
				++j;
				i=j+1;
				++j;
			}
			else if(j<s.length()-1&&s.charAt(j+1)=='X'){
				++j;
				if(j<s.length()-1&&s.charAt(j+1)=='X'){
					++j;
				}
				num=num+((j-i+1)*10);
				i=j+1;
				++j;
			}
			else{
				num+=10;
				++i;
				++j;
			}
		}
		if(i<s.length()&&s.charAt(i)=='L'){
			while(j<s.length()-1&&s.charAt(j+1)=='X'){
				++j;
			}
			num=num+50+((j-i)*10);
			i=j+1;
			++j;
		}
		if(i<s.length()&&s.charAt(i)=='I'){
			if(j<s.length()-1&&s.charAt(j+1)=='X'){
				num+=9;
			}
			else if(j<s.length()-1&&s.charAt(j+1)=='V'){
				num+=4;
			}
			else if(j<s.length()-1&&s.charAt(j+1)=='I'){
				++j;
				if(j<s.length()-1&&s.charAt(j+1)=='I'){
					++j;
				}
				num=num+(j-i+1);
			}
			else{
				num+=1;
			}
		}
		if(i<s.length()&&s.charAt(i)=='V'){
			while(j<s.length()-1&&s.charAt(j+1)=='I'){
				++j;
			}
			num=num+5+(j-i);
		}
      return num;
    }
}