class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else {
            if (strs.length == 1) {
                return strs[0];
            }
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int l = 0; l < strs.length; l++) {
                if (i >= strs[l].length() || strs[l].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }

            }
        }
        return strs[0];
    }
}
