import java.util.*;
class Solution
{
    public int romanToInt(String s)
    {
        s=s.trim()+" ";
        String sign = "MDCLXVI ";
        int value [] = {1000 , 500 , 100 , 50 , 10 , 5 , 1 , 0};
        int sum=0;

        for(int i=0 ; i<s.length()-1 ; i++)
         if(sign.indexOf(s.charAt(i))>sign.indexOf(s.charAt(i+1)))
          sum-=value[sign.indexOf(s.charAt(i))];
         else
          sum+=value[sign.indexOf(s.charAt(i))];
        return sum;
    }
}
