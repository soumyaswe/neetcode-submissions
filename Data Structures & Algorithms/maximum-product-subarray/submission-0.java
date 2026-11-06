class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 0, suffix = 0;
        int res = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[n - 1 - i] * (suffix == 0 ? 1 : suffix);

            res = Math.max(res, Math.max(prefix, suffix));
        }

        return res;
    }
}
