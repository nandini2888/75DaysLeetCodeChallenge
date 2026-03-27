class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            // Calculate how many subarrays contain arr[i]
            int totalSubarrays = (i + 1) * (n - i);
            
            // Number of odd-length subarrays is (total + 1) / 2
            int oddSubarrays = (totalSubarrays + 1) / 2;
            
            totalSum += oddSubarrays * arr[i];
        }
        
        return totalSum;
    }
}