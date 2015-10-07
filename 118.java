public class Solution {
    public List<List<Integer>> generate(int numRows) {
        int num; //暂时放要存入的数
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++)
        {
        	ArrayList<Integer> line = new ArrayList<Integer>();  //每一行的Array
        	for (int j = 0; j <= i; j++)
        	{
        		if (j == 0 || j == i)
        			line.add(1);
        		else
        		{
        			num = list.get(i-1).get(j-1)+list.get(i-1).get(j);
        			line.add(num);
        		}
        	}
        	list.add(line);
        }
        return list;
    }
}