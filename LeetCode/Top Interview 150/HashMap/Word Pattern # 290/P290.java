import java.util.*;

class Solution {
    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split("\\s+");

        if (arr.length != pattern.length())
            return false;

        Map<Character, String> check = new HashMap<>();
        Set<String> rep = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = arr[i];

            if (check.containsKey(c)) {
                if (!check.get(c).equals(word))
                    return false;
            } else {
                if (rep.contains(word))
                    return false;
                check.put(c, word);
                rep.add(word);
            }
        }

        return true;
    }
}
