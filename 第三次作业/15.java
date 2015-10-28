public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result=new LinkedList<List<Integer>>();//初始化
		List<Integer> list=new LinkedList<Integer>();//初始化
		int n=nums.length;
		this.MergeSort(nums, 0, n-1);//归并排序
		int p1,p2;//两个指针
		p1=0;
		p2=n-1;
		for(int i=0;i<n-2;i++){
			p1=i+1;
			p2=n-1;
			if(i>0&&nums[i-1]==nums[i]){continue;}//如果相同数字则跳过
		while(p1<p2){
       if(nums[p1]+nums[p2]+nums[i]==0){
				list.add(nums[i]);
				list.add(nums[p1]);
				list.add(nums[p2]);
				result.add(list);
				list=new LinkedList<Integer>();
				while(p1<p2&&nums[p1+1]==nums[p1]){
				++p1;}
				while(p1<p2&&nums[p2-1]==nums[p2]){
				--p2;}
				++p1;
				--p2;
			}
			else if(nums[p1]+nums[p2]+nums[i]>0){
				--p2;
			}
			else{
				++p1;
			}
		}
		
		}
		
		return result;
		
		
	}
	public void Merge(int[] nums,int low,int mid,int high)
	{
		int[] num=new int[nums.length];
		for(int d=low;d<=high;d++){
			num[d]=nums[d];
		}
		int i=low,j=mid+1;
		int m=i;
		while(i<=mid&&j<=high)
		{
			if(num[i]<=num[j])
			{
				nums[m]=num[i++];
			}
			else
			{
				nums[m]=num[j++];
				
			}
			++m;
		}
		while(i<=mid)
		{
			nums[m++]=num[i++];
		}
		while(j<=high)
		{
			nums[m++]=num[j++];
		}
	}

	public void MergeSort(int[] nums,int low,int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;
			MergeSort(nums,low,mid);
			MergeSort(nums,mid+1,high);
			Merge(nums,low,mid,high);
			
		}



	}
}