// Finds the minimum possible height difference by adjusting all towers by ±k without skipping negative heights.
class Solution {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        
        int diff = arr[n - 1] - arr[0];
        int shortest = arr[0] + k;
        int longest = arr[n - 1] - k;
        
        for(int i = 0; i < n - 1; i++) {
            int minH = Math.min(shortest, arr[i + 1] - k);
            int maxH = Math.max(longest, arr[i] + k);
            
            diff = Math.min(diff, maxH - minH);
        }
        
        return diff;
    }
}

// Examples:

// Input: arr[] = [1, 5, 8, 10], k = 2
// Output: 5
// Explanation: The array can be modified as [3, 3, 6, 8]. The difference between the largest and the smallest is 8 - 3 = 5.

// Input: arr[] = [3, 9, 12, 16, 20], k = 3
// Output: 11
// Explanation: The array can be modified as [6, 12, 9, 13, 17]. The difference between the largest and the smallest is 17 - 6 = 11. 

