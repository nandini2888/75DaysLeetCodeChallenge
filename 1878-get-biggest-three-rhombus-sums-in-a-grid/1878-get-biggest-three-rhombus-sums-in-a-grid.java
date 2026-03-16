import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        TreeSet<Integer> set = new TreeSet<>((a,b) -> b - a); // descending
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                // size 0 rhombus (single cell)
                set.add(grid[i][j]);
                
                for(int k = 1; k < Math.max(m,n); k++){
                    
                    if(i-k < 0 || i+k >= m || j-k < 0 || j+k >= n) break;
                    
                    int sum = 0;
                    
                    // 4 edges traversal
                    for(int t = 0; t < k; t++){
                        sum += grid[i-k+t][j+t];   // top-right
                        sum += grid[i+t][j+k-t];   // right-bottom
                        sum += grid[i+k-t][j-t];   // bottom-left
                        sum += grid[i-t][j-k+t];   // left-top
                    }
                    
                    set.add(sum);
                }
            }
        }
        
        int size = Math.min(3, set.size());
        int[] res = new int[size];
        
        int idx = 0;
        for(int val : set){
            if(idx == 3) break;
            res[idx++] = val;
        }
        
        return res;
    }
}