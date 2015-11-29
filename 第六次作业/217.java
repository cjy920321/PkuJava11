public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
		if(nums.length==0||nums.length==1){
			return false;
		}
		int i=0;
		while(i<nums.length-1){
			if(nums[i]==nums[i+1]){
				return true;
			}
			else{
				++i;
			}
		}
		return false;
    }
}