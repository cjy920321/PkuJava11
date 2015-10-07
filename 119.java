public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        int n, num; //n存计算(i,j)位置值时(i-1,j-1)的值，num存要放入的值
        list.add(1);
        for (int i = 1; i <= rowIndex; i++)
        {
        	n = 1;
        	for (int j = 1; j <= i; j++)
        	{
        		if (j == i)
        			list.add(j,1);
        		else
        		{
        			num = n + list.get(j);
        			n = list.get(j);
        			list.set(j,num);
        		}
        	}
        }
        return list;
    }
}