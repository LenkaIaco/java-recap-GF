package leetcodeTop150.IBinaryTreeGeneral;

public class CInvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        inversion(root);
        return root;
    }

    public static void inversion(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode placeholder = root.left;
        root.left = root.right;
        root.right = placeholder;
        inversion(root.left);
        inversion(root.right);
    }
}
