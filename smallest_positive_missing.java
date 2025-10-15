class Solution {
    public int missingNumber(int[] arr) {
        Arrays.sort(arr);
      
        boolean foundOne = false;
        
        for(int a : arr) {
            if(a == 1) {
                foundOne = true;
                break;
            }
        }
        
        if(!foundOne) return 1;
        
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > 0) {
                while(i < arr.length - 1 && arr[i] == arr[i + 1]) i++;
                
                if(i < arr.length - 1 && arr[i] + 1 < arr[i + 1]) {
                    return arr[i] + 1;
                }
            }
        }
        
        return arr[arr.length - 1] + 1;
    }
}

// Examples:

// Input: arr[] = [2, -3, 4, 1, 1, 7]
// Output: 3
// Explanation: Smallest positive missing number is 3.

// Input: arr[] = [5, 3, 2, 5, 1]
// Output: 4
// Explanation: Smallest positive missing number is 4.

// Input: arr[] = [-8, 0, -1, -4, -3]
// Output: 1
// Explanation: Smallest positive missing number is 1.


