// Approach: Prefix Sum + HashMap — stores first occurrence of each prefix sum to find longest 0-sum subarray
class Solution {
    int maxLength(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if(sum == 0) maxLength = i + 1;
            
            if(map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        
        return maxLength;
    }
}

// Examples:

// Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
// Output: 5
// Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].

// Input: arr[] = [2, 10, 4]
// Output: 0
// Explanation: There is no subarray with a sum of 0.

// Input: arr[] = [1, 0, -4, 3, 1, 0]
// Output: 5
// Explanation: The longest subarray with sum equals to 0 is [0, -4, 3, 1, 0]

