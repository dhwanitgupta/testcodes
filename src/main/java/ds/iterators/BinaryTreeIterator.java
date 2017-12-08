package ds.iterators;

import ds.BinaryTree;
import ds.BinaryTreeNode;

import java.util.Stack;

public class BinaryTreeIterator implements TreeIterator {

    private BinaryTree binaryTree;
    private Stack<BinaryTreeNode> inorderStack, preOrderStack;
    private BinaryTreeNode currentInorderNode, currentPreOrderNode;

    public BinaryTreeIterator(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
        this.currentInorderNode = binaryTree.getRoot();
        this.currentPreOrderNode = currentInorderNode;
    }

    public BinaryTreeNode getNextInorderElement() {

        if (inorderStack == null) {
            inorderStack = new Stack();
        }

        while(!inorderStack.isEmpty() || currentInorderNode != null) {
            if (currentInorderNode != null) {
                inorderStack.push(currentInorderNode);
                currentInorderNode = currentInorderNode.left;
            } else {
                BinaryTreeNode inorderNode = inorderStack.pop();
                currentInorderNode = inorderNode.right;
                return inorderNode;
            }
        }
        return null;
    }

    public boolean hasNextInorderElement() {
        if (inorderStack != null && inorderStack.isEmpty() && currentInorderNode == null) {
            return false;
        }

        return true;
    }

    public boolean hasNextPreOrderElement() {
        if (preOrderStack != null && preOrderStack.isEmpty() && currentPreOrderNode == null) {
            return false;
        }

        return true;
    }

    public BinaryTreeNode getNextPreOrderElement() {

        if (preOrderStack == null) {
            preOrderStack = new Stack<BinaryTreeNode>();
        }

        if (!preOrderStack.isEmpty() || currentPreOrderNode != null) {
            if (currentPreOrderNode == null) {
                currentPreOrderNode = preOrderStack.pop();
            }
            if (currentPreOrderNode != null ) {
                BinaryTreeNode preOrderNode = currentPreOrderNode;
                if (currentPreOrderNode.right != null) {
                    preOrderStack.push(currentPreOrderNode.right);
                }
                currentPreOrderNode = currentPreOrderNode.left;
                return preOrderNode;
            }
        }

        return  null;
    }
}
