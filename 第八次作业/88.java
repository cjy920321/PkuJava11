public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0)
        {
            for(int i = 0; i < n; i++)
            {
                nums1[i] = nums2[i];
            }
        }
        int i = m - 1;
        int j = n - 1; 
        while(i >= 0 && j >=0)
        {
            if(nums1[i] > nums2[j])
            {
                nums1[i + j + 1] =nums1[i];
                i--;
            }
            else
            {
                nums1[i + j + 1] =nums2[j];
                j--;
            }
        }
        if (j >= 0)
        {
            for(int k = 0; k <= j; k++)
            {
                nums1[k] = nums2[k];
            }
        }
    }
}