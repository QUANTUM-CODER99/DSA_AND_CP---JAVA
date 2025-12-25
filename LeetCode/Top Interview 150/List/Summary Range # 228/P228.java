import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
      
        for(int p1=0,p2=1;p1<nums.length;p2++) {
            while(p2<nums.length && nums[p2-1] == nums[p2]-1) p2++;
            if(p1 == p2-1)
                result.add(""+nums[p1]);
            else 
                result.add(""+nums[p1]+"->"+nums[p2-1]);
            p1 = p2;
        }

        return result;
    }
}
