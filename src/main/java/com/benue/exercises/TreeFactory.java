package com.benue.exercises;

import com.benue.exercises.tree.SimpleTreeNode;
import java.util.LinkedList;
import java.util.Queue;

class TreeFactory {

    /**
     * Create a binary tree from supplied array of integers
     * @param values array node values
     * @return new binary tree created from values
     *
     * @author Ade Lucas
     */
    static SimpleTreeNode getTree(int[] values) {

        if(values.length>0) {

            SimpleTreeNode          root    = new SimpleTreeNode(values[0]);
            Queue<SimpleTreeNode>   queue   = new LinkedList<>();

            queue.add(root);

            boolean done  = false;
            int     index = 1;

            while (!done) {

                SimpleTreeNode node     = queue.element();
                int childCount          = node.getChildCount();

                if(childCount==0) {
                    node.add(new SimpleTreeNode(values[index++]));
                    queue.add((SimpleTreeNode)node.getChildAt(0));
                } else if(childCount==1) {
                    node.add(new SimpleTreeNode(values[index++]));
                    queue.add((SimpleTreeNode)node.getChildAt(1));
                } else {
                    queue.remove();
                }

                done = (index == values.length);
            }

            return root;
        } else {
            return null;
        }
    }
}
