public class Solution {
    public int countPrimes(int n){
    	if(n<=1){
    		return 0;
    	}
    	boolean[] notPrimes=new boolean[n-1];
    	for(int i=0;i<n-1;i++){
    		notPrimes[i]=false;
    	}
      int s=0;
      for(int i=2;(i*i)<=n;i++){
    	  if(notPrimes[i-2]==true){
    		  continue;
    	  }
    	  else{
    		  int j=i*i;
    		  while(j<=n){
    			  notPrimes[j-2]=true;
    			  j=j+i;
    		  }
    	  }
      }
      for(int i=0;i<n-1;i++){
    	  if(!notPrimes[i]){
    		  ++s;
    	  }
      }
      if(!notPrimes[n-2]){
    	  --s;
      }
      return s;
   }
}