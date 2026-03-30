class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if the array is null or empty
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start by assuming the first string is the common prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // While the current string strs[i] doesn't start with 'prefix'
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);

                // If it becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}