// Sliding Window
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int start = 0, sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            while(sum > target && start < i) {
                sum -= arr[start];
                start++;
            }
            
            if(sum == target) {
                list.add(start + 1);
                list.add(i + 1);
                
                return list;
            }
            
            
        }
        
        list.add(-1);
        return list;
    }
}

// Brute Force
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            
            if(sum == target) {
                list.add(i + 1);
                list.add(i + 1);
                
                return list;
            }
            
            for(int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                
                if(sum == target) {
                    list.add(i + 1);
                    list.add(j + 1);
                    
                    return list;
                }
            }
        }
        
        list.add(-1);
        return list;
    }
}

// Examples:

// Input: arr[] = [1, 2, 3, 7, 5], target = 12
// Output: [2, 4]
// Explanation: The sum of elements from 2nd to 4th position is 12.

// Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
// Output: [1, 5]
// Explanation: The sum of elements from 1st to 5th position is 15.

// Input: arr[] = [5, 3, 4], target = 2
// Output: [-1]
// Explanation: There is no subarray with sum 2.
