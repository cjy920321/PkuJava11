public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>(); 
        Arrays.sort(nums); //对数组排序
        int i = 0;
        while (i < nums.length - 2)
        {        	
            int target = 0 - nums[i];  //将目标设为0减去当前指向的数组中的值            
            int j = i + 1, k = nums.length - 1; //以当前指向数之后的部分数组为范围            
            while (k > j)  //求解新的Two Sum问题
            {
                if (nums[j] + nums[k] == target)
                {
                    List<Integer> onelist = new ArrayList<Integer>();
                    onelist.add(nums[i]);
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
                else if (nums[j] + nums[k] < target)
                    j++;
                else
                    k--;
            }             	
            	i++;           
            while(nums[i - 1] == nums[i] && i < nums.length - 2)
            	i++;
        }
        return list;
    }
}