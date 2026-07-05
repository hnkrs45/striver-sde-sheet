import java.util.*;

// Class definition for binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Pair{
    TreeNode key;
    Integer value;
    Pair(TreeNode key, Integer value){
        this.key=key;
        this.value=value;
    }
    TreeNode getKey(){
        return this.key;
    }
    Integer getValue(){
        return this.value;
    }
    void setKey(TreeNode key){
        this.key=key;
    }
    void setValue(Integer value){
        this.value=value;
    }
}

// Class containing the method
class Solution {
    // Function to find the maximum width of binary tree
    public int widthOfBinaryTree(TreeNode root) {

        // If the root is null, return 0
        if (root == null)
            return 0;

        // Initialize max width
        int maxWidth = 0;

        // Queue to store node and its index
        Queue<Pair> q = new LinkedList<>();

        // Push root with index 0
        q.offer(new Pair(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {

            // Get size of current level
            int size = q.size();

            // Get the minimum index at this level
            int minIndex = q.peek().getValue();

            // Variables to store first and last index
            int first = 0, last = 0;

            // Traverse all nodes in this level
            for (int i = 0; i < size; i++) {

                // Get current node and index
                Pair p = q.poll();
                TreeNode node = p.getKey();
                int currIndex = p.getValue() - minIndex;

                // Update first index
                if (i == 0)
                    first = currIndex;

                // Update last index
                if (i == size - 1)
                    last = currIndex;

                // Push left child if exists
                if (node.left != null)
                    q.offer(new Pair(node.left, 
                        2 * currIndex + 1));

                // Push right child if exists
                if (node.right != null)
                    q.offer(new Pair(node.right, 
                        2 * currIndex + 2));
            }

            // Update maximum width
            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        // Return the final result
        return maxWidth;
    }
}

// Driver class
public class MaximumWidthOfABinaryTree {
    public static void main(String[] args) {

        // Create the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        // Create solution object
        Solution sol = new Solution();

        // Call the function and print result
        System.out.println("Maximum width: " + 
            sol.widthOfBinaryTree(root));
    }
}
