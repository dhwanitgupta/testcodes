package ds.models;

public class BinaryTreeNode<T> extends AbstractBinaryTreeNode<T> {

    public BinaryTreeNode(T data) {
        super(data);
    }

    public BinaryTreeNode getRight() {
        return (BinaryTreeNode)getChildAt(1);
    }

    public BinaryTreeNode getLeft() {
        return (BinaryTreeNode)getChildAt(0);
    }
}
