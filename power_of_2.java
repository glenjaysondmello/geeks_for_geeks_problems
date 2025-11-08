// Approach 1: Bitwise trick — checks if n has only one set bit (fastest way)
class Solution {
    public static boolean isPowerofTwo(int n) {
        if(n == 0) return false;
        
        return (n & (n - 1)) == 0;
    }
}

// Approach 2: Iterative division — repeatedly divides n by 2 until it becomes 1
class Solution {
    public static boolean isPowerofTwo(int n) {
        if(n == 0) return false;
        
        while(n % 2 == 0) {
            n /= 2;
        }
        
        return n == 1;
    }
}

// Examples

// Input: n = 8
// Output: true
// Explanation: 8 is equal to 2 raised to 3 (23 = 8).

// Input: n = 98
// Output: false
// Explanation: 98 cannot be obtained by any power of 2.

// Input: n = 1
// Output: true
// Explanation: (20 = 1).

