package ds;

public class BinaryTreeNode<T> extends Node<T> {
    public BinaryTreeNode left, right;

    public BinaryTreeNode(T t) {
        this.data = t;
    }
}
