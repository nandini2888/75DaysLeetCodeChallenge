class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Step 1: Compute the sum of the first 'k' elements
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        double maxSum = currentSum;
        
        // Step 2: Slide the window across the rest of the array
        for (int i = k; i < nums.length; i++) {
            // Add the next element and remove the oldest element
            currentSum += nums[i] - nums[i - k];
            // Track the highest sum found
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // Step 3: Return the average
        return maxSum / k;
    }
}