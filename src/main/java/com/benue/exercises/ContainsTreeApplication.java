package com.benue.exercises;

import com.benue.exercises.tree.SimpleTreeNode;
import com.benue.exercises.util.TreeUtils;

/**
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes
 * Create an algorithm to decide if T2 is a subtree of T1
 *
 * See if binary tree t2 is a subtree of binary tree t1
 *
 * A tree t2 is a subtree of t1 if t1 has node where the subtree of this node is identical to t2.
 * Two trees are identical if they have the same pre-order traversal - assuming the NULL nodes are represented.
 * The approach:
 *  - traverse through the larger tree, t1
 *  - when a node in t1 matches the root node of t2 call compareTree() to compare two sub-trees for equality
 */
public class ContainsTreeApplication {

    public static void main(String[] args) {

        // t2 is a subtree of t1
        int[] array1 = {1, 2, 1, 3, 1, 1, 5};
        int[] array2 = {2, 3, 1};
        int[] array3 = {1, 2, 3};

        // create the root node
        SimpleTreeNode t1 = TreeFactory.getTree(array1);
        SimpleTreeNode t2 = TreeFactory.getTree(array2);

        System.out.println();

        System.out.println("t1:");
        if (t1 != null) {
            System.out.println(TreeUtils.printTree(t1));
        }

        System.out.println("t2:");
        if (t2 != null) {
            System.out.println(TreeUtils.printTree(t2));
        }

        if(TreeUtils.containsTree(t1, t2)) {
            System.out.println("\nt2 is a subtree of t1");
        } else {
            System.out.println("\nt2 is not a subtree of t1");
        }

        SimpleTreeNode t3 = TreeFactory.getTree(array3);

        System.out.println("\n\n\nt3:");
        if (t3 != null) {
            System.out.println(TreeUtils.printTree(t3));
        }

        if(TreeUtils.containsTree(t1, t3)) {
            System.out.println("\nt3 is a subtree of t1");
        } else {
            System.out.println("\nt3 is not a subtree of t1");
        }
    }
}
