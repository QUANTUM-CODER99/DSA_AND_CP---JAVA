// P205 -> PROBLEM NUMBER 205 & M1 -> 1ST METHOD
// IF A IS ISOMORPHIC WITH RESPECT TO B THEN B SHOULD ALSO BE ISOMORPHIC WITH RESPECT TO A.

import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> a = new HashMap<>() , b = new HashMap<>();
      
        for (int i = 0; i < s.length(); i++) {
            if (!a.containsKey(s.charAt(i))) 
                a.put(s.charAt(i), t.charAt(i));
            else if (a.get(s.charAt(i)) != t.charAt(i))
                return false;

            if(!b.containsKey(t.charAt(i)))
                b.put(t.charAt(i), s.charAt(i));
            else if(b.get(t.charAt(i)) != s.charAt(i))
                return false;
        }

        return true;
    }
}
