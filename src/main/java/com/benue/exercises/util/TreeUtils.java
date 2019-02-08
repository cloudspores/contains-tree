package com.benue.exercises.util;


import com.benue.exercises.tree.SimpleTreeNode;

/**
 * Binary Tree handling utilities
 *
 * @author Ade Lucas
 */
public class TreeUtils {

    /**
     * See if binary tree t2 is a subtree of binary tree t1
     *
     * A tree t2 is a subtree of t1 if t1 has node where the subtree of this node is identical to t2.
     * Two trees are identical if they have the same pre-order traversal - assuming the NULL nodes are represented.
     * The approach:
     *  - traverse through the larger tree, t1
     *  - when a node in t1 matches the root node of t2 call compareTree() to compare two sub-trees for equality
     *
     * @param t1 binary tree - larger, container tree candidate
     * @param t2 binary tree - subtree candidate
     * @return true if t2 is a subtree of t1
     */
    public static boolean containsTree(SimpleTreeNode t1, SimpleTreeNode t2) {
        // Traverse through the larger tree, t1
        return (t2 == null) || subTree(t1, t2);
    }


    /**
     * See if the binary tree t1 contains the binary tree t2 as a subtree within t1
     *
     * @param t1 big tree
     * @param t2 sub tree
     * @return true if t1 contains t2
     */
    private static boolean subTree(SimpleTreeNode t1, SimpleTreeNode t2) {

        if (t1 == null) {
            // Big tree t1 empty & subtree still not found.
            return false;
        } else
            // If this node in t1 matches the root node of t2 then:
            // - call compareTree() to compare two sub-trees for equality
            if (t1.getUserObject() == t2.getUserObject() && compareTree(t1, t2)) {
                return true;
            }

        // Continue traversing through larger tree t1
        return subTree(t1.getLeftChild(),  t2) || subTree(t1.getRightChild(), t2);
    }

    /**
     * Compare the two subtrees to see if they are identical
     * @param t1 subtree1
     * @param t2 subtree2
     * @return true if identical
     */
    private static boolean compareTree(SimpleTreeNode t1, SimpleTreeNode t2) {

        if (t1 == null && t2 == null) {
            return true; // nothing left in the subtree
        } else if (t1 == null || t2 == null) {
            return false; // exactly one tree is empty, therefore trees don't match
        } else if (t1.getUserObject() != t2.getUserObject()) {
            return false;  // data doesn't match
        } else {
            // Continue traversing through larger tree t1
            return compareTree(t1.getLeftChild(), t2.getLeftChild()) && compareTree(t1.getRightChild(), t2.getRightChild());
        }
    }


    private static StringBuilder printTree(SimpleTreeNode node, StringBuilder prefix, boolean isTail, StringBuilder sb) {

        SimpleTreeNode left  = node.getLeftChild();
        SimpleTreeNode right = node.getRightChild();

        if(right!=null) {
            printTree(right, new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.getUserObject().toString()).append("\n");
        if(left!=null) {
            printTree(left, new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    public static String printTree(SimpleTreeNode node) {
        return printTree(node, new StringBuilder(), true, new StringBuilder()).toString();
    }
}
