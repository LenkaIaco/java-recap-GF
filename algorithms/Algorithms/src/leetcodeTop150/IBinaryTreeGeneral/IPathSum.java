package leetcodeTop150.IBinaryTreeGeneral;

import java.util.*;

/*
INCONSISTENT TEST CASES ONLINE!!

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path
such that
 adding up all the values along the path equals targetSum.
 A leaf is a node with no children.

Examples:
        5
      4    8
   11    13  4
  7  2         1
  Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: 5+4+11+2 = 22

         1
       2   3
Input: root = [1,2,3], targetSum = 5
Output: false

Input: root = [], targetSum = 0
Output: false

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */
public class IPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2),null);
        System.out.println(hasPathSum(root,1));
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root!=null&&root.left==null&&root.right==null){
            if (root.val ==targetSum){return true;} else {return false;}
        }
        return sums(root, null, targetSum,0, root);
    }

    public static boolean sums (TreeNode curr, TreeNode prev, int targetSum, int interimSum, TreeNode root){
        if (curr==null){
            if (interimSum==targetSum){
                if (prev==null ||prev==root) {
                    return false;
                } else {return true;}
            } else {return false;}
        }

        interimSum+=curr.val;
        return sums(curr.right,curr, targetSum,interimSum, root)||sums(curr.left,curr,targetSum,interimSum, root);
    }
}
