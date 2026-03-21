class Solution {
    public void moveZeroes(int[] nums) {
        // Pointer to track the position for the next non-zero element
        int lastNonZeroFoundAt = 0;

        // Iterate through the array
        for (int cur = 0; cur < nums.length; cur++) {
            // If the current element is NOT zero
            if (nums[cur] != 0) {
                // Swap the current element with the 'lastNonZeroFoundAt' element
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[cur];
                nums[cur] = temp;

                // Move the pointer forward
                lastNonZeroFoundAt++;
            }
        }
    }
}