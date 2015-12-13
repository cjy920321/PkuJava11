public class Solution {
    public boolean canWinNim(int n) {
            if (n > 0 && n % 4 != 0)
                return true;
            else
                return false;
    }
}