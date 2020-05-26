package searchBinaryTree;

import java.util.List;

public interface MyBinarySearchTree <K extends Comparable<K>, T> {

    T find(K key);
    void insert(K key, T data);
    void delete(K key);
    List<K> preOrder();
    List<K> posOrder();
    List<K> inOrder();

}
