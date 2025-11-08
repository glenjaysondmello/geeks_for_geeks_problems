class Solution {
    boolean isPalindrome(String s) {
        int n = s.length();
        
        for(int i = 0; i < n / 2; i++) {
            if(s.charAt(i) != s.charAt(n - i - 1)) return false;
        }
        
        return true;
    }
}

// Examples :

// Input: s = "abba"
// Output: true
// Explanation: "abba" reads the same forwards and backwards, so it is a palindrome.

// Input: s = "abc" 
// Output: false
// Explanation: "abc" does not read the same forwards and backwards, so it is not a palindrome.

