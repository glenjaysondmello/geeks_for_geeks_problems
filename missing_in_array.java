class Solution {
    int missingNum(int arr[]) {
        int i = 0;
        int len = arr.length;
        
        while(i < len) {
            int currIndex = arr[i] - 1;
            
            if(currIndex < len && arr[i] != arr[currIndex]) {
                arr[i] = arr[i] + arr[currIndex] - (arr[currIndex] = arr[i]);
            } else {
                i++;
            }
        }
        
        for(int j = 0; j < len; j++) {
            if(j + 1 != arr[j]) return j + 1;
        }
        
        return arr[arr.length - 1] + 1;
    }
}


// Examples:

// Input: arr[] = [1, 2, 3, 5]
// Output: 4
// Explanation: All the numbers from 1 to 5 are present except 4.

// Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
// Output: 6
// Explanation: All the numbers from 1 to 8 are present except 6.

// Input: arr[] = [1]
// Output: 2
// Explanation: Only 1 is present so the missing element is 2.

