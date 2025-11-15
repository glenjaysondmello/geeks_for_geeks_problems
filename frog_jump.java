// Approach 1: Space-optimized DP using two variables (O(1) space).
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        
        int prev1 = 0;
        int prev2 = -1;
        
        for(int i = 1; i < n; i++) {
            int second = Integer.MAX_VALUE;
            
            int first = prev1 + Math.abs(height[i] - height[i - 1]);
            if(i > 1) second = prev2 + Math.abs(height[i] - height[i - 2]);
            
            prev2 = prev1;
            prev1 = Math.min(first, second);
        }
        
        return prev1;
    }
}

// Approach 2: Bottom-up DP using a DP array (tabulation).
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        
        int[] dp = new int[n];
        dp[0] = 0;
        
        for(int i = 1; i < n; i++) {
            int second = Integer.MAX_VALUE;
            
            int first = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            if(i > 1) second = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            
            dp[i] = Math.min(first, second);
        }
        
        return dp[n - 1];
    }
}

// Approach 3: Top-down DP with memoization to avoid recomputation.
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return helper(height, n - 1, dp);
    }
    
    static int helper(int[] height, int n, int[] dp) {
        if(dp[n] != -1) return dp[n];
        
        if(n == 0) {
            dp[n] = n;
            return dp[n];
        }
        
        int second = Integer.MAX_VALUE;
        
        int first = helper(height, n - 1, dp) + Math.abs(height[n] - height[n - 1]);
        if(n > 1) second = helper(height, n - 2, dp) + Math.abs(height[n] - height[n - 2]);
        
        dp[n] = Math.min(first, second);
        
        return dp[n];
    }
}

// Approach 4: Pure recursion (no DP) — exponential time.
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        
        return helper(height, n - 1);
    }
    
    static int helper(int[] height, int n) {
        if(n == 0) return 0;
        
        int second = Integer.MAX_VALUE;
        
        int first = helper(height, n - 1) + Math.abs(height[n] - height[n - 1]);
        if(n > 1) second = helper(height, n - 2) + Math.abs(height[n] - height[n - 2]);
        
        return Math.min(first, second);
    }
}

// Example:

// Input: heights[] = [20, 30, 40, 20]
// Output: 20
// Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
// jump from stair 0 to 1: cost = |30 - 20| = 10
// jump from stair 1 to 3: cost = |20 - 30| = 10
// Total Cost = 10 + 10 = 20

// Input: heights[] = [30, 20, 50, 10, 40]
// Output: 30
// Explanation: Minimum cost will be incurred when frog jumps from stair 0 to 2 then 2 to 4:
// jump from stair 0 to 2: cost = |50 - 30| = 20
// jump from stair 2 to 4: cost = |40 - 50| = 10
// Total Cost = 20 + 10 = 30

