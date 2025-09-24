// Prefix Sum + HashMap -> O(n)
class Solution {
    public int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if(sum == k) {
                maxLen = i + 1;
            }
            
            if(map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
}


// Brute Force (Not Recommended) -> O(n^2)
class Solution {
    public int longestSubarray(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++) {
            int count = subArray(arr, i, k);
            
            max = Math.max(max, count);
        }
        
        return max;
    }
    
    static int subArray(int[] arr, int j, int k) {
        int sum = 0, count = 0, maxCount = 0;
        
        for(int i = j; i < arr.length; i++) {
            sum += arr[i];
            
            if(sum == k) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count++;
            }
        }
        
        return maxCount;
    }
}

// Examples:

// Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
// Output: 6
// Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.

// Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
// Output: 5
// Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.

// Input: arr[] = [10, -10, 20, 30], k = 5
// Output: 0
// Explanation: No subarray with sum = 5 is present in arr[].

