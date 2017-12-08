import ds.BinaryTree;
import ds.Comparator;
import ds.iterators.BinaryTreeIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Init {

    public static void main(String[] args) {

        List arrayList = new ArrayList(Arrays.asList(5,4,1,2,3,0, -1 ));
        BinaryTree binaryTree = BinaryTree.createBinaryTree(arrayList);
        binaryTree.doInorder(binaryTree.getRoot());

        BinaryTree binarySearchTree = BinaryTree.createBinarySearchTree(arrayList, new Comparator<Integer>() {
            public int compare(Integer first, Integer second) {
                if (first > second) {
                    return 1;
                }
                return -1;
            }
        });
        System.out.println();
        binarySearchTree.doInorder(binarySearchTree.getRoot());

        BinaryTreeIterator binarySearchIterator = new BinaryTreeIterator(binarySearchTree);

        System.out.println();

        while(binarySearchIterator.hasNextInorderElement()) {
            System.out.print(binarySearchIterator.getNextInorderElement().getData() + " ");
        }

        System.out.println();

        while(binarySearchIterator.hasNextPreOrderElement()) {
            System.out.print(binarySearchIterator.getNextPreOrderElement().getData() + " ");
        }

        BinaryTreeIterator binaryTreeIterator = new BinaryTreeIterator(binaryTree);

        System.out.println();

        while(binaryTreeIterator.hasNextPreOrderElement()) {
            System.out.print(binaryTreeIterator.getNextPreOrderElement().getData() + " ");
        }
    }
}
