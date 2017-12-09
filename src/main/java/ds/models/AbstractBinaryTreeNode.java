package ds.models;

import java.util.Vector;

public abstract class AbstractBinaryTreeNode<T> implements TreeNode<T>{

    private static final int MAX_CHILDS = 2;

    private Vector<AbstractBinaryTreeNode<T>> childs;
    private T data;

    public AbstractBinaryTreeNode(T data, AbstractBinaryTreeNode<T> left, AbstractBinaryTreeNode<T> right) {
        this.childs = new Vector<AbstractBinaryTreeNode<T>>(2);
        this.data = data;
        this.childs.add(left);
        this.childs.add(right);
    }

    public AbstractBinaryTreeNode(T data) {
        this(data, null, null);
    }

    public AbstractBinaryTreeNode getChildAt(int index) {
        return childs.get(index);
    }

    public abstract  AbstractBinaryTreeNode getRight();

    public abstract AbstractBinaryTreeNode getLeft();

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getMaxChilds() {
        return MAX_CHILDS;
    }

    public void setLeft(AbstractBinaryTreeNode<T> leftNode) {
        childs.set(0, leftNode);
    }

    public void setRight(AbstractBinaryTreeNode<T> rightNode) {

        childs.set(1, rightNode);
    }
}
