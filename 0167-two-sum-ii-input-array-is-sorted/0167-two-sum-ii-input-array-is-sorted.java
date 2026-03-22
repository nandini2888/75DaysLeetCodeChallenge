class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                // Problem asks for 1-based indexing
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                left++; // Need a larger value
            } else {
                right--; // Need a smaller value
            }
        }
        
        // Per constraints, a solution always exists
        return new int[]{-1, -1};
    }
}