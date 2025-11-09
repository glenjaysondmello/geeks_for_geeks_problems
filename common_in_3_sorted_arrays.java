// Approach: Three-pointer approach with duplicate skipping — efficiently finds common unique elements across three sorted arrays.
class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0, k = 0;
        
        while(i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            while(i < arr1.size() - 1 && arr1.get(i).equals(arr1.get(i + 1))) i++;
            while(j < arr2.size() - 1 && arr2.get(j).equals(arr2.get(j + 1))) j++;
            while(k < arr3.size() - 1 && arr3.get(k).equals(arr3.get(k + 1))) k++;
            
            if(arr1.get(i).equals(arr2.get(j)) && arr2.get(j).equals(arr3.get(k))) {
                res.add(arr1.get(i++));
                j++;
                k++;
            }
            else if(arr1.get(i) < arr2.get(j)) i++;
            else if(arr2.get(j) < arr3.get(k)) j++;
            else k++;
        }
        
        if(res.isEmpty()) res.add(-1);
        
        return res;
    }
}

// Examples :

// Input: arr1 = [1, 5, 10, 20, 40, 80] , arr2 = [6, 7, 20, 80, 100] , arr3 = [3, 4, 15, 20, 30, 70, 80, 120]
// Output: [20, 80]
// Explanation: 20 and 80 are the only common elements in arr1, arr2 and arr3.

// Input: arr1 = [1, 2, 3, 4, 5] , arr2 = [6, 7] , arr3 = [8,9,10]
// Output: [-1]
// Explanation: There are no common elements in arr1, arr2 and arr3.

// Input: arr1 = [1, 1, 1, 2, 2, 2], arr2 = [1, 1, 2, 2, 2], arr3 = [1, 1, 1, 1, 2, 2, 2, 2]
// Output: [1, 2]
// Explanation: We do not need to consider duplicates.

