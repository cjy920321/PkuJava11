public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>(); 
        Arrays.sort(nums); //对数组排序
        int i = 0;
        while (i < nums.length - 3)
        {
            if (nums[i] * 4 > target)
                break;
            int target1 = target - nums[i];  //将目标设为target减去当前指向的数组中的值
            int m = i + 1;
            while (m < nums.length - 2)
            {
                int newtarget = target1 - nums[m];
                int j = m + 1, k = nums.length - 1; //以当前指向数之后的部分数组为范围            
                while (k > j)  //求解新的Two Sum问题
                {
                    if (nums[j] + nums[k] == newtarget)
                    {
                        List<Integer> onelist = new ArrayList<Integer>();
                        onelist.add(nums[i]);
                        onelist.add(nums[m]);
                        onelist.add(nums[j]);
                        onelist.add(nums[k]);
                        list.add(onelist);                    
                        j++;
                        k--;
                        while (nums[j - 1] == nums[j] && j < k)
                        	j++;                    
                        while (nums[k + 1] == nums[k] && j < k)
                        	k--;
                    }    
                    else if (nums[j] + nums[k] < newtarget)
                        j++;
                    else
                        k--;
                }
                m++;
                while(nums[m - 1] == nums[m] && m < nums.length - 2)
            	    m++;
            }
            	i++;           
            while(nums[i - 1] == nums[i] && i < nums.length - 3)
            	i++;
        }
        return list;
    }
}