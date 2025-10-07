class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 1; i <= arr.length; i++) {
            map.put(i, 0);
        }
        
        for(int num : arr) {
            map.put(num, map.get(num) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 2) res.add(0, entry.getKey());
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 0) res.add(1, entry.getKey());
        }
        
        return res;
    }
}

// Examples:

// Input: arr[] = [2, 2]
// Output: [2, 1]
// Explanation: Repeating number is 2 and the missing number is 1.

// Input: arr[] = [1, 3, 3] 
// Output: [3, 2]
// Explanation: Repeating number is 3 and the missing number is 2.

// Input: arr[] = [4, 3, 6, 2, 1, 1]
// Output: [1, 5]
// Explanation: Repeating number is 1 and the missing number is 5.


