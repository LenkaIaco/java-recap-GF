package leetcodeTop150.IBinaryTreeGeneral;

public class DSymmetricTree {
    /*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Examples:

Input: root = [1,2,2,3,4,4,3]
             1
        2         2
      3   4     4   3
Output: true


Input: root = [1,2,2,null,3,null,3]
            1
      2           2
 null   3    null    3

Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
     */
    public static void main(String[] args) {
//        [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        TreeNode left11 = new TreeNode(3);
        TreeNode right12 = new TreeNode(4);
        TreeNode left21 = new TreeNode(4);
        TreeNode right22 = new TreeNode(3);

        left1.left = left11;
        left1.right = right12;

        right1.left = left21;
        right1.right = right22;

        root.left = left1;
        root.right = right1;

        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        return compareSides(root.left, root.right);
    }

    public static boolean compareSides(TreeNode left, TreeNode right){
        if (left==null&&right==null){return true;}
        if (left==null||right==null){return false;}
        if (left.val!=right.val){return false;}

        return compareSides(left.left, right.right) && compareSides(left.right, right.left);
    }
}
