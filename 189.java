   if(nums == null || nums.length < 2){
	        return;
	    }

	    k = k % nums.length;
	    revert(nums, 0, nums.length - k - 1);//��תǰlength-k��
	    revert(nums, nums.length - k, nums.length - 1);//��ת��K��
	    revert(nums, 0, nums.length - 1);//һ��ת���õ���

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