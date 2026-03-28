class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26]; // To store frequency of uppercase letters
        int left = 0;
        int maxCount = 0; // Frequency of the most common character in the current window
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update the count for the current character
            counts[s.charAt(right) - 'A']++;
            
            // Update maxCount (the character we want to match everything else to)
            maxCount = Math.max(maxCount, counts[s.charAt(right) - 'A']);

            // If the number of replacements needed > k, shrink the window from the left
            while ((right - left + 1) - maxCount > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the global maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}