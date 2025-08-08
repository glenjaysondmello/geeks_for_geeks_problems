// Kandane's algorithm
class Solution {
    int maxSubarraySum(int[] arr) {
        int max = arr[0];
        int sum = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }
        
        return max;
        
    }
}

// This is brute force (fails for large data)
class Solution {
    int maxSubarraySum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int k = 0;
        
        while(k < arr.length) {
            for(int i = k; i < arr.length; i++) {
                sum += arr[i];
            
                if(sum > max) {
                    max = sum;
                }
            }
            
            sum = 0;
            k++;
        }
        
        return max;
    }
}


// Examples:

// Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
// Output: 11
// Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.
  
// Input: arr[] = [-2, -4]
// Output: -2
// Explanation: The subarray [-2] has the largest sum -2.
  
// Input: arr[] = [5, 4, 1, 7, 8]
// Output: 25
// Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.

