// Kadane’s algorithm variation for product: track current max & min because negatives can flip signs, updating global max
class Solution {
    int maxProduct(int[] arr) {
        int n = arr.length;
        
        if(n == 0) return 0;
        
        int maxProduct = arr[0], minProduct = arr[0], res = arr[0];
        
        for(int i = 1; i < n; i++) {
            int curr = arr[i];
            
            if(curr < 0) maxProduct = maxProduct + minProduct - (minProduct = maxProduct);
            
            maxProduct = Math.max(curr, maxProduct * curr);
            minProduct = Math.min(curr, minProduct * curr);
            
            res = Math.max(res, maxProduct);
        }
        
        return res;
    }
}

// Examples

// Input: arr[] = [-2, 6, -3, -10, 0, 2]
// Output: 180
// Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.

// Input: arr[] = [-1, -3, -10, 0, 6]
// Output: 30
// Explanation: The subarray with maximum product is [-3, -10] with product = (-3) * (-10) = 30.

// Input: arr[] = [2, 3, 4] 
// Output: 24 
// Explanation: For an array with all positive elements, the result is product of all elements

