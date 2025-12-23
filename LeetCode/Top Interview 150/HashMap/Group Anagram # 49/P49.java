import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) { // IMP CONCEPT OF ITERATION
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s); // map.get(key) -> return(List) : .add(s) -> ADD STRING TO THE LIST
        }
        
        return new ArrayList<>(map.values()); // IMP LINE
    }
}
