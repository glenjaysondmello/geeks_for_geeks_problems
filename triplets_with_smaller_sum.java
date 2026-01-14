// Sort the array, Fix one element and use two pointers to count all triplets whose sum is less than the target.
class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        Arrays.sort(arr);
        
        long count = 0;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] >= sum) break;
            
            int left = i + 1;
            int right = n - 1;
            
            while(left < right) {
                long curSum = arr[i] + arr[left] + arr[right];
                
                if(curSum < sum) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return count;
    }
}


// Examples :

// Input: n = 4, sum = 2, arr[] = {-2, 0, 1, 3}
// Output:  2
// Explanation: Below are triplets with sum less than 2 (-2, 0, 1) and (-2, 0, 3). 

// Input: n = 5, sum = 12, arr[] = {5, 1, 3, 4, 7}
// Output: 4
// Explanation: Below are triplets with sum less than 12 (1, 3, 4), (1, 3, 5), (1, 3, 7) and (1, 4, 5).

