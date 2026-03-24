class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate width
            int width = right - left;
            
            // The height of the container is limited by the shorter line
            int h = Math.min(height[left], height[right]);
            
            // Update maxArea if current area is larger
            int currentArea = h * width;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}