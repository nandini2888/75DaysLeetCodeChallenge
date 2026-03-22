class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // This operation clears the least significant bit set to 1
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}