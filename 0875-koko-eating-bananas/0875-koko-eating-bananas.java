class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid; // try smaller speed
            } else {
                left = mid + 1; // need more speed
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil division
        }

        return hours <= h;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}