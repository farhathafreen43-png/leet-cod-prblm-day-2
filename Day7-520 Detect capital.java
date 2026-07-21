class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        
        // Fix 1: Added () to toCharArray()
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }
        
        // Case 1: All capitals (e.g., "USA")
        // Fix 2: Added () to word.length()
        if (upperCount == word.length()) {
            return true;
        }
        // Case 2: No capitals (e.g., "leetcode")
        if (upperCount == 0) {
            return true;
        }
        // Case 3: Only first letter capital, rest small (e.g., "Google")
        if (upperCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        
        return false;
    }
}
