package ds.factories;

import ds.models.BinaryTree;
import ds.models.BinaryTreeNode;

import java.util.List;

public class BinaryTreeBuilderStrategy implements TreeBuilderFactory {

    public <T> BinaryTree buildTree(List<T> elements) {


        if (elements == null || elements.isEmpty()) {
            return new BinaryTree(null);
        }

        BinaryTreeNode rootNode = new BinaryTreeNode(elements.get(0));
        BinaryTree binaryTree = new BinaryTree(rootNode);

        buildTreeRecursively(elements, 0, rootNode);
        return binaryTree;
    }

    private <T> void buildTreeRecursively(List<T> elements, int index, BinaryTreeNode rootNode) {
        int size = elements.size();
        int firstChildIndex = index*2 + 1;
        int secondChildIndex = index*2 + 2;

        if (rootNode == null || index >= size || firstChildIndex >= size) {
            return;
        }

        rootNode.setLeft(new BinaryTreeNode(elements.get(firstChildIndex)));

        if (secondChildIndex < size) {
            rootNode.setRight(new BinaryTreeNode(elements.get(secondChildIndex)));
        }

        buildTreeRecursively(elements, firstChildIndex, rootNode.getLeft());
        buildTreeRecursively(elements, secondChildIndex, rootNode.getRight());
    }
}
