// Uses recursion + memoization (dp) to avoid recomputing subproblems, making it efficient.
class Solution {
    public int perfectSum(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target) return 1;
        
        Integer dp[][] = new Integer[nums.length][target + 1];
        
        return helper(nums, target, 0, dp);
    }
    
    static int helper(int[] nums, int target, int i, Integer[][] dp) {
        if(i == nums.length) return target == 0 ? 1 : 0;
        
        if(dp[i][target] != null) return dp[i][target]; 
        
        int count = 0;
        
        count += helper(nums, target, i + 1, dp);
        
        if(nums[i] <= target) count += helper(nums, target - nums[i], i + 1, dp);
        
        dp[i][target] = count;
        return count;
    }
}

// Uses plain recursion without memoization, causing exponential repeated computations.
class Solution {
    public int perfectSum(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target) return 1;
        
        return helper(nums, target, 0);
    }
    
    static int helper(int[] nums, int target, int i) {
        if(i == nums.length) return target == 0 ? 1 : 0;
        
        int count = 0;
        
        count += helper(nums, target, i + 1);
        
        if(target - nums[i] >= 0) count += helper(nums, target - nums[i], i + 1);
        
        return count;
    }
}

// Builds the subset sum by accumulating a running sum, still exponential without memoization.
class Solution {
    public int perfectSum(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target) return 1;
        
        return helper(nums, target, 0, 0);
    }
    
    static int helper(int[] nums, int target, int i, int sum) {
        if(i == nums.length) return sum == target ? 1 : 0;
        
        int count = 0;
        
        count += helper(nums, target, i + 1, sum);
        
        if(sum + nums[i] <= target) count += helper(nums, target, i + 1, sum + nums[i]);
        
        return count;
    }
}

// Examples:

// Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
// Output: 3
// Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.

// Input: arr[] = [2, 5, 1, 4, 3], target = 10
// Output: 3
// Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.

// Input: arr[] = [5, 7, 8], target = 3
// Output: 0
// Explanation: There are no subsets of the array that sum up to the target 3.

// Input: arr[] = [35, 2, 8, 22], target = 0
// Output: 1
// Explanation: The empty subset is the only subset with a sum of 0.

