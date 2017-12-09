package ds.models;

public abstract class AbstractBinaryTree<T extends AbstractBinaryTreeNode> implements Tree {

    private T root;

    public AbstractBinaryTree(T root) {
        this.root = root;
    }

    public TreeType getType() {
        return TreeType.BINARY_TREE;
    }

    public T getRoot() {
        return root;
    }

}
