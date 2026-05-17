package leetcodeTop150.IBinaryTreeGeneral;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AMaximumDepthOfBinaryTree {
    /*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node
down to the farthest leaf node.


Examples:
Node 3: Nodes 9,20
Node 9: null
Node 20: Nodes 15, 7
Input: root = [3,9,20,null,null,15,7]
Output: 3


Input: root = [1,null,2]
Output: 2

Constraints:
The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
  */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Set<Integer> depths = new HashSet<>();

        countNodes(depths, root, 0);
        int maxDepth = 0;
        if (!depths.isEmpty()) {
            maxDepth = Collections.max(depths);
        }

        return maxDepth;

    }

    public static void countNodes(Set<Integer> depths, TreeNode root, int counter) {

        if (root == null) {
            depths.add(counter);
            return;
        }

        counter++;

        countNodes(depths, root.left, counter);
        countNodes(depths, root.right, counter);
    }
}
