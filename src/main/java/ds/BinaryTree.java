package ds;

import java.util.List;

public class BinaryTree<T> extends Tree {

    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    private BinaryTree(BinaryTreeNode binaryTreeNode) {
        this.root = binaryTreeNode;
    }

    public static <T> BinaryTree<T> createBinaryTree(List<T> arrayList) {
        BinaryTreeNode rootNode = new BinaryTreeNode(arrayList.get(0));
        BinaryTreeNode treeNode = rootNode;

        buildTreeRecursively(arrayList, 0, rootNode);

        return new BinaryTree<T>(rootNode);
    }

    public static <T> BinaryTree<T> createBinarySearchTree(List<T> list, Comparator<T> comparator){
        BinaryTreeNode rootNode = new BinaryTreeNode(list.get(0));

        for (int i = 1 ; i < list.size(); i++) {
            insertInBst(rootNode, list.get(i), comparator);
        }

        return new BinaryTree<T>(rootNode);
    }

    private static <T> void insertInBst(BinaryTreeNode<T> rootNode, T element, Comparator<T> comparator) {
        if (rootNode == null) {
            return;
        }

        if (comparator.compare(rootNode.data, element) > 0) {
            if (rootNode.left == null) {
                rootNode.left = new BinaryTreeNode(element);
                return;
            }
            insertInBst(rootNode.left, element, comparator);
        } else {
            if (rootNode.right == null) {
                rootNode.right = new BinaryTreeNode(element);
                return;
            }
            insertInBst(rootNode.right, element, comparator);
        }
    }

    private static <T> void buildTreeRecursively(List<T> arrayList, int index, BinaryTreeNode rootNode) {
        int size = arrayList.size();
        int firstChildIndex = index*2 + 1;
        int secondChildIndex = index*2 + 2;

        if (rootNode == null || index >= size || firstChildIndex >= size) {
            return;
        }

        rootNode.left = new BinaryTreeNode(arrayList.get(firstChildIndex));

        if (secondChildIndex < size) {
            rootNode.right = new BinaryTreeNode(arrayList.get(secondChildIndex));
        }

        buildTreeRecursively(arrayList, firstChildIndex, rootNode.left);
        buildTreeRecursively(arrayList, secondChildIndex, rootNode.right);
    }

    public void doInorder(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        doInorder(rootNode.left);
        System.out.print(rootNode.getData() + " ");
        doInorder(rootNode.right);
    }
}