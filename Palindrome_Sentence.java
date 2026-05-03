// Approach 1: Uses two-pointer technique to compare characters in-place while skipping non-alphanumeric characters (O(1) space).
class Solution {
    public boolean isPalinSent(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        
        while(left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            if(!Character.isLetterOrDigit(leftChar)) left++;
            else if(!Character.isLetterOrDigit(rightChar)) right--;
            
            else if(Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        
        return true;
    }
}

// Approach 2: Builds a cleaned lowercase string and checks palindrome by comparing it with its reversed version (O(n) extra space).
class Solution {
    public boolean isPalinSent(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()) {
            if(Character.isLetterOrDigit(ch)) sb.append(Character.toLowerCase(ch));
        }
        
        StringBuilder rev = new StringBuilder(sb.toString());
        rev.reverse();
        
        return sb.toString().equals(rev.toString());
    }
}

// Examples:

// Input: s = "Too hot to hoot"
// Output: true
// Explanation: If we remove all non-alphanumeric characters and convert all uppercase letters to lowercase, string s will become "toohottohoot" which is a palindrome.

// Input: s = "Abc 012..## 10cbA"
// Output: true
// Explanation: If we remove all non-alphanumeric characters and convert all uppercase letters to lowercase, string s will become "abc01210cba" which is a palindrome.

// Input: s = "ABC $. def01ASDF"
// Output: false
// Explanation: The processed string becomes "abcdef01asdf", which is not a palindrome.

