// Approach 1: Use HashSet to check if (target - current) exists in O(n) time.
class Solution {
    boolean twoSum(int arr[], int target) {
        if(arr.length == 1) return false;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            
            if(set.contains(comp)) return true;
            
            set.add(arr[i]);
        }
        
        return false;
    }
}

// Approach 2: Sort array and use two-pointer technique to find pair in O(n log n) time.
class Solution {
    boolean twoSum(int arr[], int target) {
        if(arr.length == 1) return false;
        
        Arrays.sort(arr);
        
        int n = arr.length;
        int left = 0, right = n - 1;
        
        while(left < right) {
            int sum = arr[left] + arr[right];
            
            if(sum > target) {
                right--;
            } else if(sum < target) {
                left++;
            } else {
                return true;
            }
        }
        
        return false;
    }
}

// Examples:

// Input: arr[] = [0, -1, 2, -3, 1], target = -2
// Output: true
// Explanation: arr[3] + arr[4] = -3 + 1 = -2

// Input: arr[] = [1, -2, 1, 0, 5], target = 0
// Output: false
// Explanation: None of the pair makes a sum of 0

// Input: arr[] = [11], target = 11
// Output: false
// Explanation: No pair is possible as only one element is present in arr[]

