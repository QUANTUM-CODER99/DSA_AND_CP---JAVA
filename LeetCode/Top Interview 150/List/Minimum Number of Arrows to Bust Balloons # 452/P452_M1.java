import java.util.*;

class Solution {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 1)
            return 1;

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0])); // FOR ARRANGING IT IN THE ASCENDING ORDER

        int arrrow = 0;

        for (int i = 0, j; i < points.length;) {
            long currentPointer = points[i][1];
            for (j = i + 1; j < points.length && currentPointer >= (long)points[j][0]; j++)
                currentPointer = Math.min(currentPointer, points[j][1]);
            arrrow++;
            i = j;
        }

        return arrrow;
    }
}
