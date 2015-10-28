public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();//初始化
		List<Integer> list=new LinkedList<Integer>();//初始化
		int p1,p2;//两个指针
		int n=nums.length;
		Arrays.sort(nums);//排序
		for(int i=0;i<n-3;i++){
			if(i>0&&nums[i-1]==nums[i]){continue;}//如果相同数字则跳过
			for(int j=i+1;j<n-2;j++){
			    if(j>i+1&&nums[j-1]==nums[j]){continue;}//如果相同数字则跳过
				p1=j+1;
				p2=n-1;
				while(p1<p2){
					if(nums[i]+nums[j]+nums[p1]+nums[p2]==target){
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[p1]);
						list.add(nums[p2]);
						result.add(list);
						list=new LinkedList<Integer>();
						while(p1<p2&&nums[p1+1]==nums[p1]){++p1;}//相同数字则指针后移
						while(p1<p2&&nums[p2-1]==nums[p2]){--p2;}//相同数字则指针前移
						++p1;
						--p2;
					}
					else if(nums[i]+nums[j]+nums[p1]+nums[p2]>target){
						--p2;
					}
					else{
						++p1;
					}
				}
			}
		}
		return result;
		
    }
}