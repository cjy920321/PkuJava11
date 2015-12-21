public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] prime = new boolean[n];
        for(int i = 2; i * i < n; i++)
        {
            for(int j = i; i * j < n; j++)
            {
                if(prime[i] == true)
                {
                    break;
                }
                prime[i*j] = true;
            }
        }
        for (int i = 2; i < n; i++)
        {
            if(prime[i] == false)
            {
                count++;
            }
        }
        return count;
    }
}