import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 1)
            return 1;

        Set<Integer> numSet = new HashSet<>();
        for(int n : nums)
            numSet.add(n);

        int maxCount =0;

        for(int n : numSet) { // 0 1 2 6 7 8 9 = 4 
            if(!numSet.contains(n-1)) { 
                int len = 1;
                while(numSet.contains(n+len)) len++;
                maxCount = Math.max(maxCount, len);
            }
        }

        return maxCount;
    }
}
