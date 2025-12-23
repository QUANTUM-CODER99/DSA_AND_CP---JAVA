class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256]; // BY DEFAULT ALL ARE 0 & 256 IS A VERY SAFE NUMBER
        int[] m2 = new int[256];
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // IF THE LAST SEEN POSITION OF ANY SPECIFIC CHARACTERS DOES NOT MATCH THEN IT IS NOT ISOMORPHIC
            if (m1[charS] != m2[charT]) { 
                return false;
            }
            
            // UPDATING THE LAST SEEN POSITION USING i+1 TO AVOIDE DEFAULT VALUE 0 ARRAYS
            m1[charS] = i + 1;
            m2[charT] = i + 1;
        }
        
        return true;
    }
}
