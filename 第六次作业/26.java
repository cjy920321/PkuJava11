public class Solution {
      public static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0)
        return 0;
    int slow = 0, fast = 1, len = nums.length;
    while (fast < len) {
        if (nums[fast] != nums[fast - 1]) {
            nums[++slow] = nums[fast];
        }
        fast++;
    }
    return slow + 1;
}
}