package leetcodeTop150.IBinaryTreeGeneral;

import java.util.*;

public class BSameTree {
    /*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     */

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        TreeNode b = new TreeNode(1);
         b.right = new TreeNode(2);

        System.out.println(isSameTree(a, b));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        Set<Boolean> comparisoms = new HashSet<>();
        oneToOneCompare(p, q, comparisoms);

        return comparisoms.contains(false) ? false : true;
    }

    public static void oneToOneCompare(TreeNode p, TreeNode q, Set<Boolean> comparisoms){
        if (p==null&&q==null){comparisoms.add(true); return;}
        if (p==null){comparisoms.add(false); return;}
        if (q==null){comparisoms.add(false); return;}

        if (p.val!=q.val){comparisoms.add(false); return;}

        oneToOneCompare(p.right, q.right, comparisoms);
        oneToOneCompare(p.left, q.left, comparisoms);
    }

//    public static void oneToOneCompare(TreeNode p, TreeNode q, Set<Boolean> comparisoms){
//        if (p==null&&q==null){comparisoms.add(true); return;}
//        if (p==null){comparisoms.add(false); return;}
//        if (q==null){comparisoms.add(false); return;}
//
//        if (p.val!=q.val){comparisoms.add(false); return;}
//
//         oneToOneCompare(p.right, q.right, comparisoms);
//         oneToOneCompare(p.left, q.left, comparisoms);
//    }
}
