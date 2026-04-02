import java.util.*;

class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        
        // dp[i][j][k] -> max coins at (i,j) with k neutralizations used
        int[][][] dp = new int[m][n][3];
        
        // Initialize with very small values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        
        // Starting cell
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0; // use neutralization
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 2; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;
                    
                    // Move right
                    if (j + 1 < n) {
                        int val = coins[i][j + 1];
                        
                        // take normally
                        dp[i][j + 1][k] = Math.max(dp[i][j + 1][k],
                                dp[i][j][k] + val);
                        
                        // use neutralization if negative
                        if (val < 0 && k < 2) {
                            dp[i][j + 1][k + 1] = Math.max(dp[i][j + 1][k + 1],
                                    dp[i][j][k]);
                        }
                    }
                    
                    // Move down
                    if (i + 1 < m) {
                        int val = coins[i + 1][j];
                        
                        // take normally
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k],
                                dp[i][j][k] + val);
                        
                        // use neutralization if negative
                        if (val < 0 && k < 2) {
                            dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1],
                                    dp[i][j][k]);
                        }
                    }
                }
            }
        }
        
        // Take max among all 3 states at destination
        return Math.max(dp[m - 1][n - 1][0],
               Math.max(dp[m - 1][n - 1][1],
                        dp[m - 1][n - 1][2]));
    }
}