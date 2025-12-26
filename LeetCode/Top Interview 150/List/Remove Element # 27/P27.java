import java.util.ArrayList;

class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0 ; i<nums.length ; i++)
        if(nums[i]!=val)
        ans.add(nums[i]);

        for(int i=0 ; i<ans.size() ; i++)
        nums[i] = ans.get(i);
        
        return ans.size();
    }
}
