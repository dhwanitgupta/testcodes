package ds.factories;

import ds.Comparator;
import ds.models.BinaryTree;
import ds.models.BinaryTreeNode;
import ds.models.Tree;

import java.util.List;

public class BinarySearchTreeBuilderStrategy implements TreeBuilderFactory {

    public <T> BinaryTree buildTree(List<T> elements, Comparator<T> comparator) {

        BinaryTreeNode rootNode = new BinaryTreeNode(elements.get(0));

        for (int i = 1 ; i < elements.size(); i++) {
            insertInBst(rootNode, elements.get(i), comparator);
        }

        return new BinaryTree(rootNode);
    }

    private static <T> void insertInBst(BinaryTreeNode<T> rootNode, T element, Comparator<T> comparator) {
        if (rootNode == null) {
            return;
        }

        if (comparator.compare(rootNode.getData(), element) > 0) {
            if (rootNode.getLeft() == null) {
                rootNode.setLeft(new BinaryTreeNode(element));
                return;
            }
            insertInBst(rootNode.getLeft(), element, comparator);
        } else {
            if (rootNode.getRight() == null) {
                rootNode.setRight(new BinaryTreeNode(element));
                return;
            }
            insertInBst(rootNode.getRight(), element, comparator);
        }
    }
}
