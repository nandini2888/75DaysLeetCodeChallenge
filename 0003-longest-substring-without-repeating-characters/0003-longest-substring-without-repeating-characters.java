class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map to store the last seen index of each character
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map, move the left pointer
            if (map.containsKey(currentChar)) {
                // We use Math.max to ensure 'left' never moves backward
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update the last seen index of the character
            map.put(currentChar, right);

            // Calculate the current window size and update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}