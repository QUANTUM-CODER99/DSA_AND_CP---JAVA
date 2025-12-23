import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> dup = new HashMap<>(); // TO STORE THERE LAST USED INDEX
      
        for(int i=0;i<nums.length;i++)
            if(dup.containsKey(nums[i]) && Math.abs(i-dup.get(nums[i]))<=k) return true;
            else dup.put(nums[i],i);
      
        return false;
    }
}
