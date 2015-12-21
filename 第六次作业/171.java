public class Solution {
   public static int titleToNumber(String s) {
     int number=0;
     for(int i=0;i<s.length();i++)
     {
        number=26*number+(s.charAt(i)-'A')+1; 
     }
     return number;
}
}