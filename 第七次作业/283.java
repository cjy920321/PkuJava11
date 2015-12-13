public class Solution {
    public void moveZeroes(int[] nums) {
        int m=0;
    	int zeroes=0;
    	int n=nums.length;
    	for(int i=0;i<n;i++){
    		if(nums[i]==0){
    			++zeroes;
    		}
    	}
    	int i=0;
    	while(m<(n-zeroes)){
    	    while(i<nums.length&&nums[i]==0){
    	    	++i;
    	    }
    		nums[m]=nums[i];
    		++m;
    		++i;
    	}
    	for(int j=m;j<n;j++){
    		nums[j]=0;
    	}
    }
}