import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> result = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            if(result.containsKey(target-nums[i]))
                return new int[] {result.get(target-nums[i]) , i};
            result.put(nums[i], i);
        }
        
        return new int[] {};
    }
}
