   if(nums == null || nums.length < 2){
	        return;
	    }

	    k = k % nums.length;
	    revert(nums, 0, nums.length - k - 1);//反转前length-k个
	    revert(nums, nums.length - k, nums.length - 1);//反转后K个
	    revert(nums, 0, nums.length - 1);//一起反转，得到答案

	}

	public static void revert(int[] nums, int i, int j){
	    int tmp = 0;       
	    while(i < j){
	        tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	        i++;
	        j--;
	    }