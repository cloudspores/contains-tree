package com.benue.exercises.tree;

import java.util.Enumeration;

/**
 * Adapted from: javax.swing.tree.TreeNode -> this class depends on nothing in AWT
 * Defines the requirements for an object that can be used as a tree node.
 */
public interface TreeNode {

    /**
     * Returns the child <code>TreeNode</code> at index
     * <code>childIndex</code>.
     */
    TreeNode getChildAt(int childIndex);

    /**
     * Returns the number of children <code>TreeNode</code>s the receiver
     * contains.
     */
    int getChildCount();

    /**
     * Returns the parent <code>TreeNode</code> of the receiver.
     */
    TreeNode getParent();

    /**
     * Returns the index of <code>node</code> in the receivers children.
     * If the receiver does not contain <code>node</code>, -1 will be
     * returned.
     */
    int getIndex(TreeNode node);

    /**
     * Returns true if the receiver is a leaf.
     */
    boolean isLeaf();

    /**
     * Returns the children of the receiver as an <code>Enumeration</code>.
     */
    Enumeration children();
}
