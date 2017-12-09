package ds.factories;

import ds.Comparator;
import ds.models.Tree;

import java.util.List;

public interface TreeBuilderFactory {

    public default <T> Tree buildTree(List<T> elements) {
        return null;
    }

    public default <T> Tree buildTree(List<T> elements, Comparator<T> comparator) {
        return null;
    }
}
