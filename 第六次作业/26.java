public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int i=0;
		int j=0;
		int m=0;
		while(j<nums.length-1){
			if(nums[i]==nums[j+1]){
				++j;
			}
			else{
				nums[m]=nums[i];
				++m;
				i=j+1;
				++j;
			}
		}
		nums[m]=nums[i];
		return m+1;
    }
}