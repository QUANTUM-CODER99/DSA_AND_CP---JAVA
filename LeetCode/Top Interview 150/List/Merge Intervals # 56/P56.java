import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // IT IS USED TO SORT THE 2D ARRAY ACCORDINGLY.
        /*
         * {3, 5} {1, 2}
         * {1, 2} --> {3, 5}
         * {4, 6} {4, 6}
         * 
         */

        List<List<Integer>> copyResult = new ArrayList<>();

        for (int i = 0, j; i < intervals.length; i = j) {
            int st = intervals[i][0];
            int end = intervals[i][1];

            for (j = i + 1; j < intervals.length && end >= intervals[j][0]; j++)
                end = Math.max(end, intervals[j][1]);

            copyResult.add(Arrays.asList(st, end));
        }

        int ans[][] = new int[copyResult.size()][2];
        for (int i = 0; i < copyResult.size(); i++) {
            ans[i][0] = copyResult.get(i).get(0);
            ans[i][1] = copyResult.get(i).get(1);
        }

        return ans;
    }
}
