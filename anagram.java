class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) return false;
        }
        
        return true;
    }
}

// Examples:

// Input: s1 = "geeks" s2 = "kseeg"
// Output: true 
// Explanation: Both the string have same characters with same frequency. So, they are anagrams.

// Input: s1 = "allergy", s2 = "allergyy" 
// Output: false 
// Explanation: Although the characters are mostly the same, s2 contains an extra 'y' character. Since the frequency of characters differs, the strings are not anagrams. 

// Input: s1 = "listen", s2 = "lists" 
// Output: false 
// Explanation: The characters in the two strings are not the same — some are missing or extra. So, they are not anagrams.

