class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = n - 1; i >= 0; i--) {
            while(!stk.isEmpty() && stk.peek() <= arr[i]) stk.pop();
            
            if(stk.isEmpty()) res.add(-1);
            else res.add(stk.peek());
            
            stk.push(arr[i]);
        }
        
        reverse(res);
        
        return res;
    }
    
    static void reverse(ArrayList<Integer> list) {
        int n = list.size();
        
        for(int i = 0; i < n / 2; i++) {
            int left = list.get(i);
            int right = list.get(n - i - 1);
            
            list.set(n - i - 1, left);
            list.set(i, right);
        }
    }
}

// Examples

// Input: arr[] = [1, 3, 2, 4]
// Output: [3, 4, 4, -1]
// Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1.

// Input: arr[] = [6, 8, 0, 1, 3]
// Output: [8, -1, 1, 3, -1]
// Explanation: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1, for 1 it is 3 and then for 3 there is no larger element on right and hence -1.

// Input: arr[] = [1, 2, 3, 5]
// Output: [2, 3, 5, -1]
// Explanation: For a sorted array, the next element is next greater element also except for the last element.

// Input: arr[] = [5, 4, 3, 1]
// Output: [-1, -1, -1, -1]
// Explanation: There is no next greater element for any of the elements in the array, so all are -1.

