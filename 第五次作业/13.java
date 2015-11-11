public class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int i = 0;
        while(s.charAt(i) == 'M')
        {
            num += 1000;
            i++;
            if (i == s.length())
                return num;
        }
        if(s.charAt(i) == 'D')
        {
            num += 500;
            i++;
            if (i == s.length())
                return num;
        }
        while(s.charAt(i) == 'C')
        {
            num += 100;
            i++;
            if (i == s.length())
                return num;
        }
        if(s.charAt(i) == 'M')
        {
            num += 800;
            i++;
            if (i == s.length())
                return num;
        }
        if(s.charAt(i) == 'D')
        {
            num += 300;
            i++;
            if (i == s.length())
                return num;
        }
        if(s.charAt(i) == 'L')
        {
            num += 50;
            i++;
            if (i == s.length())
                return num;
        }
        while(s.charAt(i) == 'X')
        {
            num += 10;
            i++;
            if (i == s.length())
                return num;
        }
        if(s.charAt(i) == 'C')
        {
            num += 80;
            i++;
            if (i == s.length())
                return num;
        }
        if(s.charAt(i) == 'L')
        {
            num += 30;
            i++;
            if (i == s.length())
                return num;
        }
        if(s.charAt(i) == 'V')
        {
            num += 5;
            i++;
            if (i == s.length())
                return num;
        }
        while(s.charAt(i) == 'I')
        {
            num += 1;
            i++;
            if (i == s.length())
                return num;
        }
        if(s.charAt(i) == 'X')
        {
            num += 8;
            i++;
            if (i == s.length())
                return num;
        }
        if(s.charAt(i) == 'V')
        {
            num += 3;
            i++;
            if (i == s.length())
                return num;
        }
        return num;
    }
}