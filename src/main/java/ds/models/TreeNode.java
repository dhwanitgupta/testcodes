package ds.models;

public interface TreeNode<T> {

    public TreeNode getChildAt(int index);
    public T getData();
    public void setData(T data);
    public int getMaxChilds();
}
