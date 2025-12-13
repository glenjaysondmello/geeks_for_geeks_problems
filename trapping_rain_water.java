// Two-pointer approach that accumulates trapped rainwater by maintaining the maximum boundary seen so far from both ends
class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int min = Integer.MIN_VALUE;;
        int count = 0;
        
        while(left < right) {
            int leftE = arr[left], rightE = arr[right];
            
            if(leftE <= rightE) {
                min = Math.max(min, leftE);
                count += min - leftE;
                left++;
            } else if(leftE > rightE){
                min = Math.max(min, rightE);
                count += min - rightE;
                right--;
            }
        }
        
        return count;
    }
}

// Examples:

// Input: arr[] = [3, 0, 1, 0, 4, 0 2]
// Output: 10
// Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

// Input: arr[] = [3, 0, 2, 0, 4]
// Output: 7
// Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.

// Input: arr[] = [1, 2, 3, 4]
// Output: 0
// Explanation: We cannot trap water as there is no height bound on both sides.

// Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
// Output: 9
// Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.

