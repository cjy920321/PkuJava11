public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
int[] nums=new int[m];
		for(int i=0;i<m;i++){
			nums[i]=nums1[i];
		}
		int i=0;
		int j=0;
		int z=0;
		while(i<m&&j<n){
			if(nums[i]<nums2[j]){
				nums1[z]=nums[i];
				++i;
				++z;
			}
			else{
				nums1[z]=nums2[j];
				++j;
				++z;
			}
		}
		while(i<m){
			nums1[z]=nums[i];
			++i;
			++z;
		}
		while(j<n){
			nums1[z]=nums2[j];
			++j;
			++z;
		}
    }
}