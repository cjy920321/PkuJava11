public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        if (nums.length > 0)
        {
            int val = nums[0];
            length++;
            for (int i = 1; i < nums.length; i++)
            {
                if (nums[i] != val)
                {
                    val = nums[i];
                    nums[length] = val;
                    length++;
                }
            }
        }
        return length;
    }
}