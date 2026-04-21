/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * Performs level-order traversal of a binary tree.
     * Returns a list where each element is a list containing values of nodes at that level.
     * 
     * @param root The root node of the binary tree
     * @return A list of lists containing node values grouped by level
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Initialize the result list to store all levels
        List<List<Integer>> result = new ArrayList<>();
      
        // Handle edge case: empty tree
        if (root == null) {
            return result;
        }
      
        // Initialize queue for BFS traversal
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
      
        // Process tree level by level
        while (!queue.isEmpty()) {
            // List to store current level's node values
            List<Integer> currentLevel = new ArrayList<>();
          
            // Get the number of nodes at current level
            int levelSize = queue.size();
          
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                // Remove and process the front node
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
              
                // Add left child to queue for next level processing
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
              
                // Add right child to queue for next level processing
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
          
            // Add current level to the result
            result.add(currentLevel);
        }
      
        return result;
    }
}
