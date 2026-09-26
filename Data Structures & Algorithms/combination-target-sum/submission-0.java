class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumUtil(0, 0, res, new ArrayList<>(), nums, target);
        return res;
    }
    private void combinationSumUtil(int currSum, int idx, List<List<Integer>> res, List<Integer> temp, int nums[], int target) {
        if(idx >= nums.length || currSum > target) 
            return;
        
        if(currSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        combinationSumUtil(currSum + nums[idx], idx, res, temp, nums, target);
        temp.remove(temp.size()-1);
        combinationSumUtil(currSum, idx+1, res, temp, nums, target);
    }
}
