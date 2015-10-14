public class Solution {
    public int removeElement(int[] nums, int val) {
       List<Integer> list=new ArrayList<Integer>();//建立list
		for(int i=0;i<nums.length;i++)//赋值
		{
			list.add(nums[i]);
		}
		for(int i=0;i<list.size();i++)//删除指定的元素
		{
			if(list.get(i)==val)
			{
				list.remove(i);
				--i;
			}
		}
		for(int i=0;i<list.size();i++)//赋值
		{
			nums[i]=list.get(i);
		}
		return list.size();//返回
    }
}