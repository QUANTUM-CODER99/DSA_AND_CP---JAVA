class Solution {
    public int[] productExceptSelf(int[] nums) {
        int output[] = new int[nums.length];
        // CORE CONCEPT -> output[i] = (prefix product index i) * (suffix product index i);

        // FOR FINDING THE PREFIX SUM ->
        output[0] = 1;
        for(int i=1;i<nums.length;i++)
            output[i] = output[i-1] * nums[i-1];

        // FOR FINDING THE SUFFIX SUM ->
        int rightProduct = 1;
        for(int i=nums.length-1 ; i>-1; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }
}
