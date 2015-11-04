public class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement=0;
		int different=0;
		for(int i=0;i<nums.length;i++){//遍历数组，删除两个不同元素，主元素是不变得 
			if(different==0){
				majorityElement=nums[i];
				++different;
			}
			else{
				if(nums[i]==majorityElement){
					++different;
				}
				else{
					--different;
				}
			}
		}
		return majorityElement;//返回
    }
}