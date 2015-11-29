public class Solution {
    public int maxProfit(int[] prices) {
	    int result=0;
		int n=prices.length;
		int i=0;
		int value=0;
		int p=0;
		int min=0;
		int medium=0;
		while(i<n-1&&prices[i]>prices[i+1]){
			++i;
		}
		int j=i;
		while(j<n-1){
			while(j<n-2&&prices[j+1]<prices[i]){
				++j;
			}
			medium=prices[j+1]-prices[i];
			if(medium>=value){
				value=medium;
				p=j+1;
				min=prices[i];
			}
			if(j==n-2){
				for(int d=i;d<p;d++){
					if(min>prices[d]){
						min=prices[d];
					}
				    value=prices[p]-min;
				    if(value>result){
				    	result=value;
				    }
				    value=0;
				    i=p+1;
				    while(i<n-1&&prices[i]>prices[i+1]){
				    	++i;
				    }
				    j=i-1;	
				}
			}
			++j;
		}
		return result;
    }
}